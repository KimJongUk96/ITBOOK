/**
 * @author Kim Jong Uk
 */

function popupOpen() {
	var popUrl = "popup.jsp"; // 팝업창에 출력될 url

	var popOption = "width=400, height=400, resizable=no, scrollbars=no, status=no;"; // 팝업창
																						// 옵션(optoin)
	window.open(popUrl, "", popOption);

}

function sendToParent(){
	window.opener.document.frm.memId.value = document.frm.memId.value;
	self.close();
	
}


