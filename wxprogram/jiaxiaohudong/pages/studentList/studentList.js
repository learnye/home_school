var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var app = getApp();
Page({
  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    dataList: [],
  },

  onLoad: function (options) {
    var that = this;
  },

  onShow: function () {
    var that = this;
    that.getDataList();
  },


  getDataList: function () {
    var that = this;
    httpUtil.postReq(uriUtil.userStudentList, {
        state: 1,
        classroomid: uriUtil.getUserInfo()['classroomid'],
      },
      function (res) {
        if (res) {
          let dataList = res.data;
          that.setData({
            dataList: dataList
          })
        }
      }, true, false);
  },

  showListPage: function (e) {
    var that = this
    let index = e.currentTarget.dataset.index;
    let student = that.data.dataList[index];
    wx.navigateTo({
      url: '../scoreManage/scoreManage?id=' + student['id'],
    })
  },
})