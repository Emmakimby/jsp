function getmenu(){
 	var set = document.info;
if(document.info.menu.value=="1"){
	set.action="Man_InfoMain.jsp"
}else if(document.info.menu.value == "2"){
	set.action="ResultMain.jsp"
}else if(document.info.menu.value == "0"){
	alert("설문 프로그램을 종료합니다.");
	set.action="end.jsp"
}
set.info.submit();
	}


function getpet(){
 	var set = document.Maninfo;
if(document.Maninfo.Pet.value=="Y"){
	set.action="Pet_TypeMain.jsp"
}else if(document.Maninfo.Pet.value == "N"){
	alert("해당 설문조사의 대상이 아닙니다.\n참여해주셔서 감사합니다.");
	set.action="info.jsp"
}
set.Maninfo.submit();
	}
	
	
function getpet2(){
 	var set = document.petinfo;
if(document.petinfo.Pet.value=="Y"){
	set.action="petinfo_insert.jsp"
}else if(document.petinfo.Pet.value == "N"){
	alert("해당 설문조사의 대상이 아닙니다.\n참여해주셔서 감사합니다.");
	set.action="petinfo_insert2.jsp"
}
set.petinfo.submit();
	}
	
	
function gettype(){
 	var set = document.pettype;
if(document.pettype.type.value=="0"){
	set.action="othertype.jsp"
}else {
	set.action="Pet_InfoMain.jsp"
}set.pettype.submit();
	}
	
function gettype2(){
 	var set = document.othtype;
if(document.othtype.typename.value==""){
	alert("반려동물의 종을 입력해주세요.")
	set.action="othertype.jsp"
}else {
	set.action="pettype_insert.jsp"
}set.othtype.submit();
	}
	
function getend(){
 	var set = document.result;
if(document.result.end.value=="info"){
	set.action="info.jsp"
}else if(document.result.end.value=="end"){
	set.action="end.jsp"
}set.result.submit();
	}