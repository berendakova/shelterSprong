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
                    console.assert("debil");
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
<form method="POST" enctype="multipart/form-data" id="fileUploadForm" style="margin-top: 300px">

    <br/><br/>
    File to upload (1): <input type="file" name="files"/><br />
    File to upload (2): <input type="file" name="files"/><br />
    File to upload (3): <input type="file" name="files"/><br />
    File to upload (4): <input type="file" name="files"/><br />
    File to upload (5): <input type="file" name="files"/><br />
    <br />
    <br />
    <input type="submit" value="Submit" id="submitButton"/>
    <br />
    <h2>Upload Results:</h2>
    <div style="border:1px solid #ccc;padding: 5px;">
        <span id="result"></span>
    </div>
</form>


<#include "include/scripts.ftlh">
</body>
</html>