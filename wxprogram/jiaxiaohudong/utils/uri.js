var CODE_NEED_AUTH_USERINFO = -3; //需要用户认证来获取用户信息
var CODE_ERROR = -1; //失败
var CODE_SUCCESS = 200; //成功
var CODE_SUCCESS_0 = 0;

var KEY_TOKEN = 'token'; //token的key
var KEY_USER_TYPE = 'userType'; //用户类型
var USER_TYPE_COURIER = 'userTypeCourier'; //
var USER_TYPE_NORMAL = 'userTypeNormal'; //
var USER_INFO = 'userInfo'; //用户信息

var IP = '127.0.0.1:8080';
var BASE_URL = 'http://' + IP + '/parentSchool/'; //BASEURL
var BASE_URL_UPLOAD = 'http://' + IP + '/parentSchool/'; //BASEURL



/**
 * 获取用户
 */
function getUserInfo() {
  return wx.getStorageSync(USER_INFO)
}

/**
 * 设置用户
 */
function setUserInfo(userInfo, cb) {
  wx.setStorage({
    key: USER_INFO,
    data: userInfo,
    success: function (res) {
      typeof cb == "function" && cb(true)
    },
    fail: function (res) {
      typeof cb == "function" && cb(false)
    }
  })
}



/**
 * 获取用户类型
 */
function getUserType() {
  return wx.getStorageSync(KEY_USER_TYPE)
}

/**
 * 设置用户类型
 */
function setUserType(isNormalUser, cb) {
  wx.setStorage({
    key: KEY_USER_TYPE,
    data: isNormalUser ? USER_TYPE_NORMAL : USER_TYPE_COURIER,
    success: function (res) {
      typeof cb == "function" && cb(true)
    },
    fail: function (res) {
      typeof cb == "function" && cb(false)
    }
  })
}


/**
 * 清除userInfo
 */
function removeUserInfo() {
  return wx.removeStorageSync(USER_INFO)
}


/**
 * 清除usertype
 */
function removeUserType() {
  return wx.removeStorageSync(KEY_USER_TYPE)
}

/**
 * 获取token
 */
function getToken() {
  return wx.getStorageSync(KEY_TOKEN)
}
/**
 * 清除token
 */
function removeToken() {
  return wx.removeStorageSync(KEY_TOKEN)
}
/**
 * 缓存token
 */
function setToken(token, cb) {
  wx.setStorage({
    key: KEY_TOKEN,
    data: token,
    success: function (res) {
      typeof cb == "function" && cb(true)
    },
    fail: function (res) {
      typeof cb == "function" && cb(false)
    }
  })
}

module.exports = {
  setToken: setToken,
  removeToken: removeToken,
  removeUserType: removeUserType,
  removeUserInfo: removeUserInfo,
  getToken: getToken,
  getUserType: getUserType,
  setUserType: setUserType,
  setUserInfo: setUserInfo,
  getUserInfo: getUserInfo,
  CODE_SUCCESS_0: CODE_SUCCESS_0,
  CODE_SUCCESS: CODE_SUCCESS,
  CODE_ERROR: CODE_ERROR,
  CODE_NEED_AUTH_USERINFO: CODE_NEED_AUTH_USERINFO,

  USER_TYPE_COURIER: USER_TYPE_COURIER,
  USER_TYPE_NORMAL: USER_TYPE_NORMAL,

  BASE_URL: BASE_URL,
  BASE_URL_UPLOAD: BASE_URL_UPLOAD,

  adviceList: "advice/getList",
  adviceAdd: "advice/add",
  adviceUpdate: "advice/update",
  chatList: "chat/getList",
  chatAdd: "chat/add",
  classroomList: "classroom/getList",
  homeworkList: "homework/getList",
  homeworkAdd: "homework/add",
  homeworkUpdate: "homework/update",
  homeworkUpdateState: "homework/updateState",
  answerList:"answer/getList",
  answerAdd: "answer/add",
  answerUpdate: "answer/update",
  answerUpdateState: "answer/updateState",
  noticeList: "notice/getList",
  classnoticeList:"classnotice/getList",
  classnoticeAdd: "classnotice/add",
  classnoticeUpdate: "classnotice/update",
  classnoticeUpdateState:"classnotice/updateState",
  scoreList: "score/getList",
  scoreAdd: "score/add",
  scoreUpdate: "score/update",
  scoreUpdateState: "score/updateState",
  userParentList: "userParent/getList",
  userParentAdd: "userParent/add",
  userParentUpdate: "userParent/update",
  userParentUpdateState: "userParent/updateState",
  userStudentList: "userStudent/getList",
  userStudentAdd: "userStudent/add",
  userStudentUpdate: "userStudent/update",
  userStudentUpdateState: "userStudent/updateState",
  userTeacherList: "userTeacher/getList",
  userTeacherAdd: "userTeacher/add",
  userTeacherUpdate: "userTeacher/update",
  userTeacherUpdateState: "userTeacher/updateState",

  UPLOAD_FILE: "upload/uploadImg",
}