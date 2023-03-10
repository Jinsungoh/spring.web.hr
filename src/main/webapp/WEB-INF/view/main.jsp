<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script> 
<script>
function listLaborers(){
	   $.ajax({
	      url:'laborer/list',
	      success: laborerList => {
	         laborers = []
	         laobrerList.forEach(laborer => {
	            laborers.push(
	                  '<li>' + 
	                     laborer.laborerId + ', ' +
	                     laborer.laborername + ', ' +
	                     laborer.hireDate + 
	                  '</li>')
	         })
	         
	         $('#laborerList').empty()
	         $('#laborerList').append(laborers.join(''))
	      }
	   })
	}

	$(() => {
	   $('#addLaborerBtn').click(() => {
	      $.ajax({
	         url: 'laborer/add',
	         method: 'post',
	         contentType:'application/json',
	         data: JSON.stringify({
	            laborerId: $('#laborerId').val(),
	            laborername: $('#laborername').val(),
	            hiredate: $('#hireDate').val()
	         }),
	         success: listLaborers
	      })
	   })
	   
	   $('#fixLaborerBtn').click(() => {
	      $.ajax({
	         url: 'laborer/fix',
	         method: 'put',
	         contentType:'application/json',
	         data: JSON.stringify({
	            laborerId: $('#laborerId').val(),
	            laborername: $('#laborername').val(),
	            hiredate: $('#hireDate').val()
	         }),
	         success: listLaborers
	      })
	   })
	   
	   $('#delLaborerBtn').click(() => {
	      $.ajax({
	         url: 'laborer/del/' + $('#laborerId').val(),
	         method: 'delete',
	         success: listLaborers
	      })
	   })
	})
</script>
</head>
<body>
    <div class='container'>
    <div class='row mb-5'>
        <div class='col'>
            <header class='p-2 bg-light shadow'>
                <h1 class='text-center'><b>HR</b></h1>
            </header>
        </div>
    </div>
    <div class='row'>
        <div class='col'>
            <form>
                <div class='row mb-3'>
                    <div class='col-2'>
                        <input type='text' class='form-control' placeholder='노동자명' id='laborerName'/>
                    </div>
                    <div class='col-5'>
                        <div class='row'>
                            <div class='col-4 d-none d-md-inline text-end align-bottom pt-2'>
                                <label for='hireDate'>입사일: </label>
                            </div>
                            <div class='col'>
                                <input type='date' class='form-control' id='hireDate'
                                    placeholder='입사일' required/>
                            </div>
                        </div>
                    </div>
                    <div class='col'>
                        <div class='gap-2 d-flex justify-end'>
                            <button type='button' class='btn btn-primary' id='addLaborerBtn'>
                                <i class='bi bi-plus-circle'></i>
                                <span class='label d-none d-md-inline'>&nbsp;추가</span>
                            </button>
                            <button type='button' class='btn btn-success' id='fixLaborerBtn'>
                                <i class='bi bi-check-circle'></i>
                                <span class='label d-none d-md-inline'>&nbsp;수정</span>
                            </button>
                            <button type='button' class='btn btn-danger' id='delLaborerBtn'>
                                <i class='bi bi-x-circle'></i>
                                <span class='label d-none d-md-inline'>&nbsp;삭제</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class='row'>
                    <div class='col'>
                        <table class='table'>
                            <thead class='table-warning'>
                                <tr>
                                    <th></th>
                                    <th>ID</th>
                                    <th>이름</th>
                                    <th>입사일</th>
                                </tr>
                            </thead>
                            <tbody id='laborers'>                  
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class='modal fade' id='modal'>
    <div class='modal-dialog'>
        <div class='modal-content'>
            <div class='modal-header'>
                <button type='button' class='btn-close' data-bs-dismiss='modal'></button>
            </div>
            <div class='modal-body'>
                <p id='modalMsg'></p>
            </div>
            <div class='modal-footer' id='modalBtn'>
                <button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>아니오</button>
                <button type='button' class='btn btn-primary' id='delLaborerOkBtn'>예</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>