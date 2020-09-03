var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var homeUtil = require('../../utils/home.js');
var app = getApp();
Page({

  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
  },

  onLoad: function () {
    var that = this;
  },

  homeworkListPage: function () {
    wx.navigateTo({
      url: '../homeworkList/homeworkList',
    })
  },
  answerListPage: function () {
    wx.navigateTo({
      url: '../answerList/answerList',
    })
  },

  scoreListPage: function () {
    wx.navigateTo({
      url: '../scoreList/scoreList',
    })
  },
  teacherListPage: function () {
    wx.navigateTo({
      url: '../teacherList/teacherList',
    })
  },
  classnoticeListPage: function () {
    wx.navigateTo({
      url: '../classnoticeList/classnoticeList',
    })
  },
  noticeListPage: function () {
    wx.navigateTo({
      url: '../noticeList/noticeList',
    })
  },
  adviceAddPage: function () {
    wx.navigateTo({
      url: '../adviceEdit/adviceEdit',
    })
  },
  adviceListPage: function () {
    wx.navigateTo({
      url: '../adviceList/adviceList',
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