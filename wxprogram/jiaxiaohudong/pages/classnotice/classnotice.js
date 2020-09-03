// pages/classnotice/classnotice.js
var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var cameraUtil = require('../../utils/camera.js');
var app = getApp();
Page({
  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    editData: {},
    imageList: [{
      type: 'local',
      path: '../../images/album_camera.png'
    }],
    maxImageCount: 10,
    id: '',
    edit: false,
    requesting: false
  },

  onLoad: function (options) {
    var that = this;
    let id = options['id'];
    let edit = (id && id != 'undefined') ? 'true' : false;
    that.setData({
      id: id,
      edit: edit,
      editData: {}
    })
    cameraUtil.init(that, that.data.maxImageCount);
    if (edit) {
      that.getDataList();
    }
  },


  getDataList: function () {
    var that = this;
    let param = {
      state: 1,
    }
    if (that.data.edit) {
      param['id'] = that.data.id
    }
    httpUtil.postReq(uriUtil.classnoticeList, param,
      function (res) {
        if (res) {
          let dataBean = res.data[0];
          let imageList = that.data.imageList;
          imageList.splice(0, 0, {
            type: 'remote',
            path: dataBean['coverImg']
          })
          that.setData({
            editData: dataBean,
            imageList: imageList
          })
        }
      }, true, false);
  },

  onInput: function (e) {
    let that = this;
    let field = e.currentTarget.dataset.field;
    let value = e.detail.value;
    let editData = that.data.editData;
    editData[field] = value.trim();
    that.setData({
      editData: editData
    })
  },

  deleteImage: function (e) {
    cameraUtil.deleteImage(e);
  },

  showImgs: function (e) {
    cameraUtil.showImgs(e);
  },

  chooseImage: function () {
    let that = this;
    let imageList = that.data.imageList;
    if (imageList.length > that.data.maxImageCount) {
      wx.showModal({
        title: '提示',
        content: '最多可上传' + that.data.maxImageCount + '张图片'
      })
      return;
    }
    cameraUtil.chooseImage((that.data.maxImageCount + 1) - imageList.length);
  },

  save: function (e) {
    let that = this;
    let finish = e.currentTarget.dataset.finish;
    let requesting = that.data.requesting;
    let edit = that.data.edit;
    let editData = that.data.editData;
    if (!editData['name']) {
      wx.showModal({
        title: '提示',
        content: '公告名称不能为空'
      })
      return;
    }




    if (!editData['content']) {
      wx.showModal({
        title: '提示',
        content: '公告详情不能为空'
      })
      return;
    }




    if (that.data.imageList.length == 1) {
      wx.showModal({
        title: '提示',
        content: '请选择图片'
      })
      return;
    }
    editData['coverImg'] = that.data.imageList[0]['path'];

    let params = {
      name: editData['name'],
      content: editData['content'],
      coverImg: editData['coverImg'],
      teacherid: uriUtil.getUserInfo()['id'],
      classroomid: uriUtil.getUserInfo()['classroomid'],
    },
      url;
    if (edit) {
      params['id'] = editData['id'];
      url = uriUtil.classnoticeUpdate;
    } else {
      url = uriUtil.classnoticeAdd;
    }

    if (requesting) {
      return;
    }
    that.data.requesting = true;
    httpUtil.postReq(url, params,
      function (res) {
        if (res) {
          if (finish == 'yes') {
            wx.navigateBack({
              delta: 1
            })
          } else {
            that.setData({
              editData: {

              },
              imageList: [{
                type: 'local',
                path: '../../images/album_camera.png'
              }]
            })
          }
          wx.showToast({
            title: (edit ? '修改' : '添加') + '成功',
          })
        }
        that.data.requesting = false;
      }, true, false);
  }
})