<%@ include file="/header.jsp" %> 
 

<h2>Agendar Consulta</h2>

<hr />

<div class="row">
<div class="col-sm-12">


 

<form action="${linkTo[ConsultsController].add}" method="post" class="form-horizontal">
	
	<div class="row">
		<div class="col-sm-6">
				<div class="form-group">
				<label   for="pwd">Médico</label>
				<select class="form-control" name="consult.doctor_id" >				 
				    <c:forEach items="${doctors}" var="doctor">
				            <option value="${doctor.id}">${doctor.name}</option>
				    </c:forEach>
				   </select>
				</div> 			
		</div>
		
		<div class="col-sm-6">
				<div class="form-group">
				<label   for="pwd">Paciente</label>
				<select class="form-control" name="consult.patient_id" >				 
				    <c:forEach items="${patients}" var="patient">
				            <option value="${patient.id}">${patient.name}</option>
				    </c:forEach>
				   </select>
				</div> 			
		</div>
		
		<div class='col-sm-3'>
            <div class="form-group">
            <label   for="date">Data</label>
                <div class='input-group date' id='date'>
                    <input type='text' class="form-control" name="consult.date"  data-date-format="DD/MM/YYYY"/>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        
        <div class='col-sm-2'>
            <div class="form-group">
            <label   for="ini_time">Hora início</label>
                <div class='input-group date' id='ini_time'>
                    <input type='text' class="form-control" name="consult.ini_time"  
                    data-date-format="HH:mm" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span>
                    </span>
                </div>
            </div>
        </div>
        
        <div class='col-sm-2'>
            <div class="form-group">
            <label   for="end_time">Hora final</label>
                <div class='input-group date' id='end_time'>
                    <input type='text' class="form-control" name="consult.end_time"  
                    data-date-format="HH:mm" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span>
                    </span>
                </div>
            </div>
        </div>
        
        
        <div class="col-sm-12">
         <div class="form-group">
            <label   for="observation">Observação</label>
        <textarea class="form-control" id="observation"  name="consult.observation" rows="3"></textarea>
        </div>
        
        </div>
        
		
		
	</div>
		
		
		
		
		
		
		
		
		
		
		
 
    <script type="text/javascript">
        $(function () {
        	$('#date').datetimepicker({pickTime: false});
        	 
            $('#ini_time').datetimepicker({pickDate: false});
            $('#end_time').datetimepicker({pickDate: false});
            $("#ini_time").on("dp.change",function (e) {
               $('#end_time').data("DateTimePicker").setMinDate(e.date);                 
            });
            $("#end_time").on("dp.change",function (e) {
               $('#ini_time').data("DateTimePicker").setMaxDate(e.date);
            });
        });
    </script> 
     









	
		
	
	<div class="row">
		<div class="form-group pull-right">					
					<button type="submit" class="btn btn-large btn-primary">
						<fmt:message key="send"/>
					</button>
		 </div>
	</div>
  </form>
</div> 

</div>

 
  

  

<%@ include file="/footer.jsp" %> 