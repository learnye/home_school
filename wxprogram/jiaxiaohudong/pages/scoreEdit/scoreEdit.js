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



  save: function (e) {
    let that = this;
    let finish = e.currentTarget.dataset.finish;
    let requesting = that.data.requesting;
    let edit = that.data.edit;
    let editData = that.data.editData;
    if (!editData['name']) {
      wx.showModal({
        title: '提示',
        content: '标题不能为空'
      })
      return;
    }


    if (!editData['content']) {
      wx.showModal({
        title: '提示',
        content: '平时表现或教师评语不能为空'
      })
      return;
    }


    if (!editData['subject']) {
      wx.showModal({
        title: '提示',
        content: '科目不能为空'
      })
      return;
    }

    if (editData['score'] != 0 && !editData['score']) {
      wx.showModal({
        title: '提示',
        content: '请填写科目分数'
      })
      return;
    }

    let params = {
        name: editData['name'],
        content: editData['content'],
        subject: editData['subject'],
        score: editData['score'],
        teacherid: uriUtil.getUserInfo()['id'],
        studentid: that.data['studentid']
      },
      url;
    if (edit) {
      params['id'] = editData['id'];
      url = uriUtil.scoreUpdate;
    } else {
      url = uriUtil.scoreAdd;
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