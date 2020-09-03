var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var homeUtil = require('../../utils/home.js');
var app = getApp();
Page({

  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    countDown: 3
  },

  onLoad: function () {
    var that = this;
  },

  homeworkManagePage: function () {
    wx.navigateTo({
      url: '../homeworkManage/homeworkManage',
    })
  },
  answerManagePage: function () {
    wx.navigateTo({
      url: '../answerManage/answerManage',
    })
  },
  classnoticeManagePage: function () {
    wx.navigateTo({
      url: '../classnoticeManage/classnoticeManage',
    })
  },
  studentListPage: function () {
    wx.navigateTo({
      url: '../studentList/studentList',
    })
  },
  parentListPage: function () {
    wx.navigateTo({
      url: '../parentList/parentList',
    })
  },
  noticeListPage: function () {
    wx.navigateTo({
      url: '../noticeList/noticeList',
    })
  },

  logout: function () {
    uriUtil.removeToken();
    uriUtil.removeUserInfo();
    uriUtil.removeUserType();
    wx.reLaunch({
      url: '../splash/splash',
    })
  },


})