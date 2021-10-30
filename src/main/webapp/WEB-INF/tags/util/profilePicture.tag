<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<style>

    .profile-pic {
        max-width: 200px;
        max-height: 200px;
        display: block;
    }

    .file-upload {
        display: none;
    }

    .circle {
        border-radius: 1000px !important;
        overflow: hidden;
        width: 128px;
        height: 128px;
        border: 5px solid rgba(0, 255, 255, 1);

    }

    img {
        max-width: 100%;
        height: auto;
    }
</style>

<script type="text/javascript">

    fetchProfilePicture = () => {

        if (UserProfileDAO.getInstance().getProfilePicturePath() !== null) {
            //profileCompletenessActions(UserProfileDAO.getInstance().getProfileCompletedStatus());
            $(".profile-pic").attr("src", "");
        } else {
            forcePullProfilePicture();
        }

    }

    forcePullProfilePicture = () => {
        const jwtToken = JwtDAO.getInstance().getJWT();
        unRegisterOnChangeOnImg();
        const request = {
            api: 'survey/user/getProfilePicture',
            requestBody: '',
            serviceCallback: function (response) {
                if (response.status !== 200 && response.status !== 404) {
                    alert('Error fetching Profile Picture. Contact support.');
                } else if (response.status === 200) {
                    $('.profile-pic').attr('src', 'data:image/png;base64,' + response.data);
                }
                registerOnChangeOnImg();
            },
            jwt: jwtToken
        }
        //console.log('Request json', request);
        RestClient.getInstance().get(request);
    }

    function registerOnChangeOnImg() {
        $(".file-upload").on('change', function () {
            readURL(this);
        });
    }

    function unRegisterOnChangeOnImg() {
        $(".file-upload").off('change');
    }

    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);

                var formData = new FormData();
                formData.append("file", input.files[0]);
                const jwtToken = JwtDAO.getInstance().getJWT();
                const request = {
                    api: 'survey/user/updateProfilePicture',
                    requestBody: formData,
                    serviceCallback: postProfilePictureUploadCallback,
                    jwt: jwtToken,
                    multipartRequest: 'yes'
                }
                //console.log('Request json', request);
                RestClient.getInstance().post(request);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    var postProfilePictureUploadCallback = (response) => {
        if (response.status !== 200) {
            alert("Something gone wrong while changing Profile Picture. Contact Support");
        }
    }

    $(document).ready(function () {

        registerOnChangeOnImg();
        fetchProfilePicture();
    });
</script>

<div class="row" style="margin-left: 5%;">
  <div class="col-2">
    <div class="circle">
      <!-- User Profile Image -->
      <img class="profile-pic" src="/resources/assets/img/profile-picture/sample_profile_picture.jpeg">
      <!-- Default Image -->
      <!-- <i class="fa fa-user fa-5x"></i> -->
    </div>
    <div class="p-image" onclick="javascript: $('.file-upload').click();">
      <i class="fa fa-camera upload-button"></i>

    </div>
    <input class="file-upload" type="file" accept="image/*"/>
  </div>
</div>
