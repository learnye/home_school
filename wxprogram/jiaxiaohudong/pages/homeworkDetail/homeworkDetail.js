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
    httpUtil.postReq(uriUtil.homeworkList, param,
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
})