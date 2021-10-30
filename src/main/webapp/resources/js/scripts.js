//##################### GLOBAL CONFIG VAR ###########################
backendApiUrl = 'http://localhost:9097/api';
defaultCountryUuid = 'b37bb43f-affe-11eb-b70f-56000308a40f|USA';
defaultAddressTypeUuid = 'de850117-ada5-11eb-b70f-56000308a40f';
parentQuestion = 'parent_question';
oneChoiceQuestion = 'onechoice';
multiChoiceQuestion = 'manychoice';

//##################### GLOBAL CONFIG VAR ENDS ###########################
/*!
    * Start Bootstrap - SB Admin v6.0.3 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
(function ($) {
  "use strict";

  // Add active state to sidbar nav links
  var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
  $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function () {
    if (this.href === path) {
      $(this).addClass("active");
    }
  });

  // Toggle the side navigation
  $("#sidebarToggle").on("click", function (e) {
    e.preventDefault();
    $("body").toggleClass("sb-sidenav-toggled");
  });
})(jQuery);


function doRedirect(url) {
  window.location.href = url;
}

function parseJwt(token) {
  var base64Url = token.split('.')[1];
  var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  var jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
    return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
  }).join(''));

  return JSON.parse(jsonPayload);
};