/**
 * @author Kim Jong Uk
 */

function popupOpen() {
	
	window.open("admin/mailPopup.jsp","","width=400, height=400, resizable =no, scollbars= no, status = no");
	/*var popUrl = "admin/mailPopup.jsp"; // 팝업창에 출력될 url
*/
	/*var popOption = "width=400, height=400, resizable=no, scrollbars=no, status=no;"; // 팝업창
																						// 옵션(optoin)
	window.open(popUrl, "", popOption);
*/
}

/*function sendToParent(){
	window.opener.document.frm.subject.value = document.frm.subject.value;
	window.opener.document.frm.body.value = document.frm.body.value;
	self.close();
	
}*/


