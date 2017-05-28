
function login() {
	var login = document.getElementById("login")
	login.style.display = "inline"
}

function back(){
	window.location.reload();
}

window.onload=function() {
	window.setInterval("realSysTime()" , 1000);
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function realSysTime() {
	var now = new Date();
	var day = now.getDay();
	var arr_week = ["星期日", "星期一","星期二" ,"星期三" ,"星期四" ,"星期五" ,"星期六"];
	var week = arr_week[day];

	var time1 = now.Format("hh : mm : ss");
	var time2 = now.Format("yyyy年MM月dd日")+week;

	var clock1 = document.getElementById("yq_time1");
	clock1.innerHTML =  time1;
	var clock2 = document.getElementById("yq_time2");
	clock2.innerHTML =  time2;
}

function check() {
	var login = document.getElementById('login');
	var id = form.id.value
	var password = form.password.value
	
	if (id=="") {
    	alert("学号不能为空");
    	form.id.focus();
        form.id.select();
    	return false;
	}
	if (password == "") {
		alert("密码不能为空");
		form.password.focus();
        form.password.select();
		return false;
	}

	login.style.display = "none";

    return true;
}