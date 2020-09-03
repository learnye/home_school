var uriUtil = require('../../utils/uri.js');
var httpUtil = require('../../utils/http.js');
var app = getApp();
Page({
  data: {
    baseUrl: uriUtil.BASE_URL,
    baseImgUrl: uriUtil.BASE_URL_UPLOAD,
    dataList: [],
    isParent: true,
    id: '',
    token: '',
    editData: {

    },
    loading:'',
    lastRequestDatetime: 0
  },

  onLoad: function (options) {
    var that = this;
    let id = options['id'];
    let name = options['name'];
    let userType = uriUtil.getUserType();
    let isParent = true;
    if (userType == uriUtil.USER_TYPE_NORMAL) {
      isParent = true;
    } else {
      isParent = false;
    }
    that.setData({
      isParent: isParent,
      name: name,
      id: id,
      token: uriUtil.getUserInfo()['id']
    })
    wx.setNavigationBarTitle({
      title: isParent ? ('与' + name + '老师的聊天') : '与' + name + '家长的聊天',
    })
   
    
  },
  timer:function(){
    let that = this;
  that.data.loading=setInterval(
      function(){
        that.getDataList();
      },1000
    )
  },

  onShow: function () {
    this.timer();
  },
  onUnload:function(){
    let that =this;
    clearInterval(that.data.loading);
  },
  onHide:function(){
    let that = this;
    clearInterval(that.data.loading);
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

  getDataList: function () {
    var that = this;
    let myInfo = uriUtil.getUserInfo();
    let isParent = that.data.isParent;
    let teacherid = isParent ? that.data.id : myInfo['id'];
    let parentid = isParent ? myInfo['id'] : that.data.id;
    httpUtil.postReq(uriUtil.chatList, {
        state: 1,
        parentid: parentid,
        tuid: teacherid
      },
      function (res) {
        if (res) {
          let dataList = res.data;
          that.setData({
            dataList: dataList,
            scrollintoView: 'item' + dataList.length
          })
        }
      }, true, false);
  },

  sendMsg: function () {
    let that = this;
    let editData = that.data.editData;
    if (!editData['content']) {
      wx.showModal({
        title: '提示',
        content: '发送内容不能为空'
      })
      return;
    }
    let myInfo = uriUtil.getUserInfo();
    let isParent = that.data.isParent;
    let teacherid = isParent ? that.data.id : myInfo['id'];
    let parentid = isParent ? myInfo['id'] : that.data.id;

    let params = {
      content: editData['content'],
      fromName: myInfo['name'],
      fromAvatarUrl: myInfo['avatarUrl'],
      tuid: teacherid,
      parentid: parentid,
      type: isParent ? 1 : 2
    };
    httpUtil.postReq(uriUtil.chatAdd, params,
      function (res) {
        if (res) {
          that.setData({
            editData: {
              content: ''
            },


          })

          that.getDataList();
        }
      }, true, false);
  }
})