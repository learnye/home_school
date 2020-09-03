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
    studentid: '',
    edit: false,
    requesting: false
  },

  onLoad: function (options) {
    var that = this;
    let id = options['id'];
    let studentid = options['studentid'];
    let edit = (id && id != 'undefined') ? 'true' : false;
    that.setData({
      id: id,
      studentid: studentid,
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
    httpUtil.postReq(uriUtil.scoreList, param,
      function (res) {
        if (res) {
          let dataBean = res.data[0];

          that.setData({
            editData: dataBean,
          })
        }
      }, true, false);
  },

  
})