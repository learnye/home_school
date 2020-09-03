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
    let studentid = options['id'];
    that.setData({
      studentid: studentid
    })
  },

  onShow: function () {
    var that = this;
    that.getDataList();
  },


  getDataList: function () {
    var that = this;
    httpUtil.postReq(uriUtil.scoreList, {
        state: 1,
        studentid: that.data.studentid,
        teacherid: uriUtil.getUserInfo()['id'],
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

  showEditPage: function (e) {
    var that = this
    let index = e.currentTarget.dataset.index;
    let type = e.currentTarget.dataset.type;
    let id;
    if (type == 'edit') {
      id = that.data.dataList[index]['id'];
    }
    wx.navigateTo({
      url: '../scoreEdit/scoreEdit?id=' + id + '&studentid=' + that.data.studentid,
    })
  },
  deleteItem: function (e) {
    var that = this;
    let index = e.currentTarget.dataset.index;
    let id = that.data.dataList[index]['id'];

    wx.showModal({
      title: '提示',
      content: '您确定要删除该条目么？',
      success: function (res) {
        if (res.confirm) {
          httpUtil.postReq(uriUtil.scoreUpdateState, {
              state: 2,
              id: id
            },
            function (res) {
              if (res) {
                that.getDataList();
              }
            }, false, true);
        }
      }
    })
  },
})