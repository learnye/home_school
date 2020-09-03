var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var app = getApp();
Page({
  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    isNormalUser: true,
    userInfo: {
      username: '',
      password: '',
      type: 1
    }
  },

  onLoad: function (options) {
    var that = this;
  },
  onInput: function (e) {
    let typename = e.currentTarget.dataset.typename;
    let value = e.detail.value;
    this.setUserinfoData(typename, value)
  },

  onRadioChange: function (e) {
    let value = e.detail.value;
    let userInfo = this.data.userInfo;
    userInfo['type'] = value;
    this.setData({
      isNormalUser: value == 1,
      userInfo: userInfo
    })
  },

  setUserinfoData: function (key, value) {
    let userInfo = this.data.userInfo;
    userInfo[key] = value;
    this.setData({
      userInfo: userInfo
    })
  },
  login: function () {
    let that = this;
    let userInfo = that.data.userInfo;
    //判断输入项
    let isAllInput = that.checkIsAllInput(userInfo);
    if (!isAllInput) {
      wx.showToast({
        title: '请把表单填写完整',
        icon: 'none',
        duration: 2000
      })
      return;
    }
    //提交表单
    let url = userInfo['type'] == 1 ? uriUtil.userParentList : uriUtil.userTeacherList;
    httpUtil.postReq(url, userInfo,
      function (res) {
        let list = res.data;
        if (list && list.length == 1) {
          wx.showToast({
            title: '登录成功',
          })
          uriUtil.setUserType(userInfo['type'] == 1);
          uriUtil.setUserInfo(res.data[0])
          if (userInfo['type'] == 1) {
            //家长
            wx.redirectTo({
              url: '../parentHome/parentHome',
            })
          } else {
            //教师
            wx.redirectTo({
              url: '../teacherHome/teacherHome',
            })
          }
        } else {
          wx.showModal({
            title: '提示',
            content: '用户名或密码有误'
          })
        }
      });
  },


  checkIsAllInput: function (obj) {
    let isAllInput = true;
    Object.keys(obj).forEach(function (key) {
      console.log(key, obj[key]);
      if (!obj[key]) {
        isAllInput = false;
      }
    });
    return isAllInput;
  },

  showRegistView: function () {
    wx.navigateTo({
      url: '../register/register',
    })
  }
})