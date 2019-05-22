/**
 * @author 정원
 * 독서모임 신청확인란 유효성검사
 */

function meetingCheck(){
	
	if(document.frm.metName.value.length == 0) {
		alert("독서모임명을 입력하세요.");
		return false;
	}
	if (document.frm.metIntro.value.length == 0) {
		alert("독서모임소개글을 입력하세요.");
		return false;
	}
	if (document.frm.represent.value.length == 0) {
		alert("대표자명을 입력하세요.");
		return false;
	}
	return true;
}

function checkSub(){
	
	var boxCount = 0;
	var checkboxs = document.getElementsByName("checkSub[]");
	var url = "meeting?command=meetingApply";
	
	for(var i = 0; i < checkboxs.length; i++){
		if(eval(checkboxs[i].checked) == true) {
			boxCount++;
		}
		if(boxCount<=0) {
			alert("활동주제를 선택해주세요.");
			return;
		}else {
			document.checkSub.submit(url);
		}
	}
}