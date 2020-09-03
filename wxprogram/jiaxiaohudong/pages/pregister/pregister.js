// pages/pregister/pregister.js
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
  },

  onLoad: function (options) {
    var that = this;
    that.setData({
      editData: {}
    })
    cameraUtil.init(that, that.data.maxImageCount);
  },


  getDataList: function () {
    var that = this;
    let param = {
      state: 1,
    }
    httpUtil.postReq(uriUtil.userParentList, param,
      function (res) {
        if (res) {
          let dataBean = res.data[0];
          let imageList = that.data.imageList;
          imageList.splice(0, 0, {
            type: 'remote',
            path: dataBean['avatarUrl']
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
    let editData = that.data.editData;
    if (!editData['username']) {
      wx.showModal({
        title: '提示',
        content: '账号不能为空'
      })
      return;
    }

    if (!editData['password']) {
      wx.showModal({
        title: '提示',
        content: '密码不能为空'
      })
      return;
    }

    if (!editData['name']) {
      wx.showModal({
        title: '提示',
        content: '昵称不能为空'
      })
      return;
    }

    if (!editData['gender']) {
      wx.showModal({
        title: '提示',
        content: '性别不能为空'
      })
      return;
    }

    if (!editData['age']) {
      wx.showModal({
        title: '提示',
        content: '年龄不能为空'
      })
      return;
    }


    if (!editData['phone']) {
      wx.showModal({
        title: '提示',
        content: '电话不能为空'
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

    if (!editData['studentid']) {
      wx.showModal({
        title: '提示',
        content: '学生ID不能为空'
      })
      return;
    }

    if (!editData['classroomid']) {
      wx.showModal({
        title: '提示',
        content: '班级ID不能为空'
      })
      return;
    }
    editData['avatarUrl'] = that.data.imageList[0]['path'];

    let params = {
      username: editData['username'],
      password: editData['password'],
      name: editData['name'],
      gender: editData['gender'],
      age: editData['age'],
      avatarUrl: editData['avatarUrl'],
      phone: editData['phone'],
      studentid: editData['studentid'],
      classroomid: editData['classroomid']
    }

    httpUtil.postReq(uriUtil.userParentAdd, params,
      function (res) {
        if (res) {
          if (finish == 'yes') {
            wx.redirectTo({
              url: '../splash/splash',
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
            title:  '注册成功',
          })
        }
      }, true, false);
  }
})