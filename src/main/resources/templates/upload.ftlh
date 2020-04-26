<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Upload Files</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" >
        $(document).ready(function() {

            $("#submitButton").click(function(event) {

                // Stop default form Submit.
                event.preventDefault();

                // Call Ajax Submit.

                ajaxSubmitForm();

            });

        });

        function ajaxSubmitForm() {

            // Get form
            var form = $('#fileUploadForm')[0];

            var data = new FormData(form);


            $("#submitButton").prop("disabled", true);

            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "/rest/uploadMultiFiles",
                data: data,

                // prevent jQuery from automatically transforming the data into a query string
                processData: false,
                contentType: false,
                cache: false,
                timeout: 1000000,
                success: function(data, textStatus, jqXHR) {

                    $("#result").html(data);
                    console.log("SUCCESS : ", data);
                    $("#submitButton").prop("disabled", false);
                    $('#fileUploadForm')[0].reset();
                },
                error: function(jqXHR, textStatus, errorThrown) {

                    $("#result").html(jqXHR.responseText);
                    console.log("ERROR : ", jqXHR.responseText);
                    $("#submitButton").prop("disabled", false);

                }
            });

        }
    </script>

    <#include "include/links.ftlh">
</head>
<body>
<#include "include/header.ftlh">

<form method="POST" style="margin-top: 150px"  enctype="multipart/form-data" id="fileUploadForm" >
    <p style="margin-bottom: 20px">You can upload jpg-file with your pet</p>
    <br/>
    <input type="text" name="description"  id="reg"style="width:350px;"/>
    <br/><br/>

    <input type="file" name="files"/><br />

    <input style="margin-top: 30px" type="submit" value="Submit" id="reg" />
    <br/><br/>
    <h4>Upload Results:</h4>
    <div style="border:1px solid #ccc;padding: 5px;">
        <span id="result"></span>
    </div>
</form>

<#include "include/scripts.ftlh">
</body>
</html>