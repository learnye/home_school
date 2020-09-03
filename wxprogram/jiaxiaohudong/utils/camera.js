var uriUtil = require('./uri.js');
var that;
var mChooseCount;
var mImgWidth;
var mImgHeight;
var mCb;
var mCanvasId;

function init(context, chooseCount, cb) {
  that = context;
  mChooseCount = chooseCount;
  mCb = cb;
  return this;
}
// 点击加_压缩
function takePhoto() {
  // let imgViewList = that.data.imgViewList; //这个是用来承载页面循环展示图片的
  //拍照、从相册选择上传
  wx.chooseImage({
    count: mChooseCount, //这个是上传的最大数量，默认为9
    sizeType: ['compressed'], //这个可以理解为上传的图片质量类型（官方给的），虽然没什么卵用，要不然还要我们自己写压缩做什么
    sourceType: ['album', 'camera'], //这个是图片来源，相册或者相机
    success: function (res) {
      var tempFilePaths = res.tempFilePaths //这个是选择后返回的图片列表
      typeof mCb == "function" && mCb(tempFilePaths)
    }
  });
}
//压缩并获取图片，这里用了递归的方法来解决canvas的draw方法延时的问题
function getCanvasImg(index, failNum, tempFilePaths) {
  if (index < tempFilePaths.length) {
    const ctx = wx.createCanvasContext(mCanvasId);
    ctx.drawImage(tempFilePaths[index], 0, 0, mImgWidth, mImgHeight);
    ctx.draw(true, function () {
      index = index + 1; //上传成功的数量，上传成功则加1
      wx.canvasToTempFilePath({
        canvasId: mCanvasId,
        success: function success(res) {
          typeof mCb == "function" && mCb(res.tempFilePath)
          getCanvasImg(index, failNum, tempFilePaths);
        },
        fail: function (e) {
          console.log(e);
          failNum += 1; //失败数量，可以用来提示用户
          getCanvasImg(index, failNum, tempFilePaths);
        }
      });
    });
  }
}
//上传图片
function uploadCanvasImg(canvasImg) {
  var that = this;
  let imgViewList = that.data.imgViewList;
  var tempImg = canvasImg;
  wx.uploadFile({
    url: app.d.fileServer, //文件服务器的地址
    filePath: tempImg,
    formData: {
      paramPath: "gift"
    },
    name: 'file',
    success: function (res) {
      var json2map = JSON.parse(res.data);
      imgViewList.push(app.d.imageUrlFix + json2map[0].fileUrl);
      that.setData({
        imgViewList: imgViewList,
      })
    }
  })
}


function deleteImage(e) {
  wx.showModal({
    title: '删除图片',
    content: '您确定要删除该图片么',
    cancelText: '删除',
    cancelColor: '#f40',
    confirmText: '取消',
    confirmColor: '#c1c1c1',
    success(res) {
      if (res.cancel) {
        let index = e.currentTarget.dataset.index;
        let imageList = that.data.imageList;
        imageList.splice(index, 1);
        that.setData({
          imageList: imageList
        })
      }
    }
  })
}

function showImgs(e) {
  let index = e.currentTarget.dataset.index;
  let imageList = JSON.parse(JSON.stringify(that.data.imageList));
  imageList.splice(imageList.length - 1);
  let urls = [];
  for (let i = 0; i < imageList.length; i++) {
    urls.push(that.data.baseImgUrl + imageList[i]['path']);
  }
  wx.previewImage({
    urls: urls,
    current: imageList[index],
  })
}

function chooseImage(chooseCount) {
  init(that, chooseCount, function (res) {
    //上传
    wx.showLoading({
      title: '正在上传...',
    })
    uploadImage(res, 0);
  });
  takePhoto();
}

function uploadImage(localImageArr, startPos) {
  if (startPos >= localImageArr.length) {
    wx.hideLoading();
    return;
  }
  wx.uploadFile({
    url: uriUtil.BASE_URL + uriUtil.UPLOAD_FILE,
    filePath: localImageArr[startPos],
    name: 'file',
    success(res) {
      let data = JSON.parse(res.data);
      let imageUrl = data['msg'];
      let imageList = that.data.imageList;
      imageList.splice(imageList.length - 1, 0, {
        type: 'remote', //local和 remote
        path: imageUrl
      })
      that.setData({
        imageList: imageList
      })
    },
    complete: function () {
      uploadImage(localImageArr, ++startPos);
    }
  })
}
module.exports = {
  init: init,
  takePhoto: takePhoto,
  chooseImage: chooseImage,
  deleteImage: deleteImage,
  showImgs: showImgs,
}