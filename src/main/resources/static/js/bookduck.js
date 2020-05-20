/* divId : 페이징 태그가 그려질 div pageIndx : 현재 페이지 위치가 저장될 
   input 태그 id recordCount : 페이지당 레코드 수 
   totalCount : 전체 조회 건수 
   eventName : 페이징 하단의 숫자 등의 버튼이 클릭되었을 때 호출될 함수 이름 
*/

var gfv_pageIndex = null;

var gfv_eventName = null;

function gfn_renderPaging(params) {



	var divId = params.divId; //페이징이 그려질 div id 

	gfv_pageIndex = params.pageIndex; //현재 위치가 저장될 input 태그 

	var totalCount = params.totalCount; //전체 조회 건수 

	var currentIndex = params.pageIndex;
	//$("#"+params.pageIndex).val(); //현재 위치 


	if (params.pageIndex.length == 0 || gfn_isNull(currentIndex) == true) {
		currentIndex = 1;
	}

	var recordCount = params.recordCount; //페이지당 레코드 수 

	if (gfn_isNull(recordCount) == true) { recordCount = 10; }

	var totalIndexCount = Math.ceil(totalCount / recordCount); // 전체 인덱스 수 

	gfv_eventName = params.eventName;

	$("#" + divId).empty(); var preStr = "";

	var postStr = "";

	var str = "";


	var first = (parseInt((currentIndex - 1) / 10) * 10) + 1;

	var last = (parseInt(totalIndexCount / 10) == parseInt(currentIndex / 10)) ? totalIndexCount % 10 : 10;

	var prev = (parseInt((currentIndex - 1) / 10) * 10) - 9 > 0 ? (parseInt((currentIndex - 1) / 10) * 10) - 9 : 1;

	var next = (parseInt((currentIndex - 1) / 10) + 1) * 10 + 1 < totalIndexCount ? (parseInt((currentIndex - 1) / 10) + 1) * 10 + 1 : totalIndexCount;

	if (totalIndexCount > 10) { //전체 인덱스가 10이 넘을 경우, 맨앞, 앞 태그 작성 
		preStr += "<a href='#this' class='pad_5' onclick='_movePage(1)'>[<<]</a>" + "<a href='#this' class='pad_5' onclick='_movePage(" + prev + ")'>[<]</a>";

	} else if (totalIndexCount <= 10 && totalIndexCount > 1) { //전체 인덱스가 10보다 작을경우, 맨앞 태그 작성 
		preStr += "<a href='#this' class='pad_5' onclick='_movePage(1)'>[<<]</a>";
	}

	if (totalIndexCount > 10) { //전체 인덱스가 10이 넘을 경우, 맨뒤, 뒤 태그 작성 
		postStr += "<a href='#this' class='pad_5' onclick='_movePage(" + next + ")'>[>]</a>" + "<a href='#this' class='pad_5' onclick='_movePage(" + totalIndexCount + ")'>[>>]</a>";

	} else if (totalIndexCount <= 10 && totalIndexCount > 1) { //전체 인덱스가 10보다 작을경우, 맨뒤 태그 작성 
		postStr += "<a href='#this' class='pad_5' onclick='_movePage(" + totalIndexCount + ")'>[>>]</a>";
	}

	for (var i = first; i < (first + last); i++) {
		if (i != currentIndex) {
			str += "<a href='#this' class='pad_5' onclick='_movePage(" + i + ")'>" + i + "</a>";
		} else { str += "<b><a href='#this' class='pad_5' onclick='_movePage(" + i + ")'>" + i + "</a></b>"; }
	}

	$("#" + divId).append(preStr + str + postStr);
}


function _movePage(value) {
	$("#" + gfv_pageIndex).val(value);
	if (typeof (gfv_eventName) == "function") {
		gfv_eventName(value);
	} else {
		eval(gfv_eventName + "(value);");
	}
}





function gfn_isNull(str) {
	if (str == null) return true;
	if (str == "NaN") return true;
	if (new String(str).valueOf() == "undefined")
		return true;
	var chkStr = new String(str);
	if (chkStr.valueOf() == "undefined") return true;
	if (chkStr == null) return true;
	if (chkStr.toString().length == 0)
		return true;
	return false;
}



function ajaxMove(path) {

	if (path == "/shelves") {

		if (localStorage.getItem("Authorization") == null) {

			alert("로그인을 먼저 해주세요");

			ajaxMove('login');
			return false;
		}

	}

	if (localStorage.getItem("Authorization") != null) {

		$.ajaxSetup({
			headers: {

				'Authorization': window.localStorage.getItem("Authorization")
			}
		});
	}




	$.ajax({
		type: "GET",
		url: path,
		dataType: "text",
		error: function () {
			alert('통신실패!!');
		},
		success: function (data) {

			$('#content').html(data);

		}

	});

}


function bookRegister() {


	// event.preventDefault();

	var $form = $('#bookShelves'),
		params = $form.serialize(),
		url = $form.attr('action');


	$.ajax({
		type: 'POST',
		url: '/user',
		dataType: 'json',
		data: params,

		success: function (data, textStatus, xhr) {

			console.log(data);
			console.log(textStatus);
			console.log(xhr);

			alert('성공적으로 회원가입에 성공하셨습니다.')

			ajaxMove('login')

		},
		error: function (xhr, error_text, statusText) {


			console.log(error_text);
			console.log(statusText);
			console.log(xhr);



			alert('성공적으로 회원가입에 성공하셨습니다.')

			ajaxMove('login')


			alert("통신이 실패했습니다. 관리자에게 문의해주세요.");


		}
	});

}


function userRegister() {

	const $form = $('#user-form'),
		params = $form.serialize(),
		url = $form.attr('action');


	$.ajax({
		type: 'POST',
		url: '/user',
		dataType: 'json',
		data: params,

		success: function (data, textStatus, xhr) {

			console.log(data);
			console.log(textStatus);
			console.log(xhr);

			alert('성공적으로 회원가입에 성공하셨습니다.')

			ajaxMove('login')

		},
		error: function (xhr, error_text, statusText) {


			console.log(error_text);
			console.log(statusText);
			console.log(xhr);



			alert('성공적으로 회원가입에 성공하셨습니다.')

			ajaxMove('login')


			alert("통신이 실패했습니다. 관리자에게 문의해주세요.");


		}
	});

}



const searchBooks = (targetPage) => {

	if (targetPage > 100) {
		alert("검색결과는 1000건까지만 제공하고 있습니다.");
		return false;
	}


	const searchBooks = {};
	searchBooks["keyword"] = $("#keyword").val();
	searchBooks["type"] = $("#type").val();

	if (targetPage == undefined) {
		searchBooks["start"] = 1;
		targetPage = 1;
	} else {
		searchBooks["start"] = targetPage;
	}


	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/search/book",
		data: searchBooks,
		dataType: 'json',
		cache: false,
		timeout: 600000,

		success: function (data) {

			let line = '';


			if (data.total == 0) {

				line = `
					<h4 class="center">요청하신 검색어로는 검색결과가 존재하지 않습니다</h4>
					`
				const pageResult = ``;
				$('#searchPaging').html(pageResult);

			} else {


				$(data.items).each(function (index, item) {

					line += `
						<table  style="width:100%; border: 0px solid black; margin-bottom : 5px;">
						<tr>
							<td rowspan=5 style="width :15%; "><img src="${item.image}"/></td>
							<td style="width :85%">${item.title}</td>
						</tr>
						<tr>
							<td>저자 : ${item.author}</td>
						</tr>
						<tr>
							<td>출판사 : ${item.publisher}</td>
						</tr>						
						<tr>
							<td>${item.description}</td>
						</tr>
						<tr>
							

							<td>
							`;
					if (localStorage.getItem("Authorization") != null) {
						line += `
									<input type="button" onclick="bookShelvesRegister('${item.title}', '${item.image}', '${item.author}', '${item.publisher}', '${item.isbn}', '${item.link}')" value="책추가"/>									
								`;
					}

					line += `

							</td>
						</tr>						
						</table>
						`;


				});

				const params = {
					divId: "searchPaging",
					pageIndex: targetPage,
					totalCount: data.total,
					eventName: "searchBooks"
				};

				gfn_renderPaging(params);

			}


			$('#searchResult').html(line);



		},
		error: function (e) {


			alert("에러가 발생했습니다. 관리자에게 문의해 주세요.");


		}
	});

};


const bookShelvesRegister = (titleRaw, imageRaw, authorRaw, publicsherRaw, isbnRaw, link) => {

	//정규식
	const replaceTitle = titleRaw.replace(/(<([^>]+)>)/ig, "");

	$("#titleRaw").val(replaceTitle);
	$("#imageRaw").val(imageRaw);
	$("#authorRaw").val(authorRaw);1
	$("#isbnRaw").val(isbnRaw);
	$("#publicsherRaw").val(publicsherRaw);


	const $form = $('#book-form'),
		params = $form.serialize(),
		url = $form.attr('action');

	const request = $.ajax({
		type: "POST",
		url: url,
		data: params,
		timeout: 2000,
	});

	request.done(function (msg) {
		alert("성공적으로 서재에 책을 추가하였습니다");
	});

	request.fail(function (jqXHR, textStatus) {
	});

	request.always(function () {
	});

};

const onlyNumber = () => {

	if ((event.keyCode < 48) || (event.keyCode > 57))

		event.returnValue = false;

}


const openComment = (isbn) => {

	const words = isbn.split(' ');

	const isbnraw =  words[0]+words[1];

	const params = { "isbn": isbnraw };

	$.ajaxSetup({
		headers: {

			'Authorization': window.localStorage.getItem("Authorization")
		}
	});

	const request = $.ajax({
		type: "GET",
		url: "/bookShelves/bookComment",
		data: params,
		timeout: 2000,
	});

	request.done(function (data) {

		let bookComment;



		if(data.userId == null) {

			bookComment	 = `<h3>아직 책에 대한 감상을 적어주지 않으셨군요</h3>
							<h3>책에 대한 감상평을 남겨주세요</h3>`;
			bookComment += `<input type="hidden" id="isbnRaw" value=`;
			bookComment += isbnraw;
			bookComment	+= `><p><input type="text" id="commentRaw" ></p>
							<p><input class="bookComment-submit" type="button" value="저장" onclick=bookCommentRegister();></p>`
			;

		} else {

			console.log(data);

			bookComment	 = `<h3>책에 대한 느낌은</h3>`;
			bookComment += '<input type="hidden" id="isbnRaw" value=' 
			bookComment += data.isbn;
			bookComment	+= `><p><input type="text" id="commentRaw" value="${data.comment}" ></p>
							<p><input class="bookComment-submit" type="button" value="저장" onclick=bookCommentRegister();></p>`			
		}


	
		$('#bookCommentW').html(bookComment);


	});

	request.fail(function (jqXHR, textStatus) {
	});

	request.always(function () {
	});




}

const bookCommentRegister = () => {

	const commn = $("#commentRaw").val();

	$("#commentData").val(commn);
	$("#isbn").val($("#isbnRaw").val());

	const $form = $('#bookCommentForm'),
		params = $form.serialize(),
		url = $form.attr('action');



	$.ajax({
		type: 'POST',
		url: '/bookShelves/bookComment',
		dataType: 'json',
		data: params,

		success: function (data, textStatus, xhr) {

			console.log(data);
			console.log(textStatus);
			console.log(xhr);

			alert('성공적으로 감상평이 등록되었습니다.')



		},
		error: function (xhr, error_text, statusText) {


			console.log(error_text);
			console.log(statusText);
			console.log(xhr);


		}
	});


}

