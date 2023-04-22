<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Course | List</title>

    <!-- Prevent the demo from appearing in search engines -->
    <meta name="robots" content="noindex">

    <!-- Perfect Scrollbar -->
    <link type="text/css" href="/vendor/perfect-scrollbar.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- App CSS -->
    <link type="text/css" href="/css/app.css" rel="stylesheet">
    <link type="text/css" href="/css/app.rtl.css" rel="stylesheet">

    <!-- Material Design Icons -->
    <link type="text/css" href="/css/vendor-material-icons.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-material-icons.rtl.css" rel="stylesheet">

    <!-- Font Awesome FREE Icons -->
    <link type="text/css" href="/css/vendor-fontawesome-free.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-fontawesome-free.rtl.css" rel="stylesheet">

    <!-- ion Range Slider -->
    <link type="text/css" href="/css/vendor-ion-rangeslider.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-ion-rangeslider.rtl.css" rel="stylesheet">


    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-115115077-4"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }
        gtag('js', new Date());

        gtag('config', 'UA-115115077-4');
    </script>



    <!-- Facebook Pixel Code -->
    <script>
        ! function(f, b, e, v, n, t, s) {
            if (f.fbq) return;
            n = f.fbq = function() {
                n.callMethod ?
                    n.callMethod.apply(n, arguments) : n.queue.push(arguments)
            };
            if (!f._fbq) f._fbq = n;
            n.push = n;
            n.loaded = !0;
            n.version = '2.0';
            n.queue = [];
            t = b.createElement(e);
            t.async = !0;
            t.src = v;
            s = b.getElementsByTagName(e)[0];
            s.parentNode.insertBefore(t, s)
        }(window, document, 'script',
            '../connect.facebook.net/en_US/fbevents.js');
        fbq('init', '340571383230227');
        fbq('track', 'PageView');
    </script>
    <noscript><img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=340571383230227&amp;ev=PageView&amp;noscript=1" /></noscript>
    <!-- End Facebook Pixel Code -->




    <!-- Flatpickr -->
    <link type="text/css" href="/css/vendor-flatpickr.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-flatpickr.rtl.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-flatpickr-airbnb.css" rel="stylesheet">
    <link type="text/css" href="/css/vendor-flatpickr-airbnb.rtl.css" rel="stylesheet">

    <!-- Vector Maps -->
    <link type="text/css" href="/vendor/jqvmap/jqvmap.min.css" rel="stylesheet">



</head>

<body class="layout-default">


    <div class="mdk-drawer-layout js-mdk-drawer-layout" data-push data-responsive-width="992px" data-fullbleed>
        <div class="mdk-drawer-layout__content">

            <!-- Header Layout -->
            <div class="mdk-header-layout js-mdk-header-layout" data-has-scrolling-region>

                <!-- Header -->

                <div id="header" class="mdk-header js-mdk-header m-0" data-fixed data-effects="waterfall" data-retarget-mouse-scroll="false">
                    <div class="mdk-header__content">

                       
                        </div> <div class="navbar navbar-expand-sm navbar-main navbar-dark bg-primary pl-md-0 pr-0" id="navbar" data-primary>
                            <div class="container-fluid page__container pr-0">

                                <!-- Navbar toggler -->
                                <button class="navbar-toggler navbar-toggler-custom  d-lg-none d-flex mr-navbar" type="button" data-toggle="sidebar">
                                    <span class="material-icons icon-14pt">menu</span>
                                </button>




                                
                            </div>

                    </div>
                </div>

                <!-- // END Header -->

                <!-- Header Layout Content -->
 <!-- Header Layout Content -->
                <div class="mdk-header-layout__content mdk-header-layout__content--fullbleed mdk-header-layout__content--scrollable page" style="padding-top: 60px;">


                     <div class="page__heading border-bottom">
                        <div class="container-fluid page__container d-flex align-items-center">
                            <h1 class="mb-0">Lessons</h1>
                        </div>
                    </div>
                    <div class="container-fluid page__container">
                        <div class="row">
                            <div class="col-md-4 order-12">
                                <div class="card card-margin-md-negative-40">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item bg-light">
                                            <a href="profile.html" class="flex d-flex align-items-center text-body text-underline-0">
                                                <span class="avatar mr-3">
                                                    <img src="assets/images/avatar/demi.png" alt="avatar" class="avatar-img rounded-circle">
                                                </span>
                                                <span class="flex d-flex flex-column">
                                                    <strong>Adrian Demian</strong>
                                                    <small class="text-muted text-uppercase">AUTHOR</small>
                                                </span>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="mr-2">
                                                <a href="#" class="rating-link active"><i class="material-icons">star</i></a>
                                                <a href="#" class="rating-link active"><i class="material-icons">star</i></a>
                                                <a href="#" class="rating-link active"><i class="material-icons">star</i></a>
                                                <a href="#" class="rating-link active"><i class="material-icons">star</i></a>
                                                <a href="#" class="rating-link active"><i class="material-icons">star_half</i></a>
                                            </span>
                                            <strong>4.7</strong>
                                            <span class="text-muted">(391 ratings)</span>
                                        </li>

                                        <li class="list-group-item">
                                            <strong>3872 people</strong> <span class="text-muted">completed this course</span>
                                        </li>
                                        <li class="list-group-item">
                                            <a href="#" class="btn btn-facebook btn-rounded-social">
                                                <svg width="14px" style="fill: currentColor;" role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                                    <title>Facebook icon</title>
                                                    <path d="M22.676 0H1.324C.593 0 0 .593 0 1.324v21.352C0 23.408.593 24 1.324 24h11.494v-9.294H9.689v-3.621h3.129V8.41c0-3.099 1.894-4.785 4.659-4.785 1.325 0 2.464.097 2.796.141v3.24h-1.921c-1.5 0-1.792.721-1.792 1.771v2.311h3.584l-.465 3.63H16.56V24h6.115c.733 0 1.325-.592 1.325-1.324V1.324C24 .593 23.408 0 22.676 0" />
                                                </svg>
                                            </a>
                                            <a href="#" class="btn btn-twitter btn-rounded-social">
                                                <svg width="14px" style="fill: currentColor;" role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                                    <title>Twitter icon</title>
                                                    <path d="M23.954 4.569c-.885.389-1.83.654-2.825.775 1.014-.611 1.794-1.574 2.163-2.723-.951.555-2.005.959-3.127 1.184-.896-.959-2.173-1.559-3.591-1.559-2.717 0-4.92 2.203-4.92 4.917 0 .39.045.765.127 1.124C7.691 8.094 4.066 6.13 1.64 3.161c-.427.722-.666 1.561-.666 2.475 0 1.71.87 3.213 2.188 4.096-.807-.026-1.566-.248-2.228-.616v.061c0 2.385 1.693 4.374 3.946 4.827-.413.111-.849.171-1.296.171-.314 0-.615-.03-.916-.086.631 1.953 2.445 3.377 4.604 3.417-1.68 1.319-3.809 2.105-6.102 2.105-.39 0-.779-.023-1.17-.067 2.189 1.394 4.768 2.209 7.557 2.209 9.054 0 13.999-7.496 13.999-13.986 0-.209 0-.42-.015-.63.961-.689 1.8-1.56 2.46-2.548l-.047-.02z" />
                                                </svg>
                                            </a>
                                            <a href="#" class="btn btn-secondary btn-rounded-social">
                                                <i class="material-icons">mail</i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-8">

                                <div class="mb-3"><strong class="text-dark-gray">DESCRIPTION</strong></div>
                                <p class="mb-3">
                                    This course is for Rails newbies and anyone looking to get a solid foundation. It’s designed to teach you everything you need to start building web applications in Rails right away.
                                </p>


                                <div class="">
                                    <ul class="list-group list-lessons">
                                    <c:forEach items="${lessons }" var="list">
                                    	<li class="list-group-item d-flex">
                                            <a href="playvideostudent?link=${list.videoLink }&title=${list.videoTitle}&courseId=${courseId}">${list.videoTitle}</a>
                                            <div class="ml-auto d-flex align-items-center">
                                                
                                                <span class="text-muted"><i class="material-icons icon-16pt icon-light">watch_later</i> 1:42</span>
                                            </div>
                                        </li>
                                    </c:forEach>
                                        
                                       
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>



                </div>
                <!-- // END header-layout__content -->

            </div>
            <!-- // END header-layout -->

        </div>
        <!-- // END drawer-layout__content -->

       <%@ include file="sidebar.jsp" %>
    </div>
    <!-- // END drawer-layout -->

    

    <!-- App Settings FAB -->
    <div id="app-settings">
        <app-settings layout-active="default" :layout-location="{
      'default': 'index.html',
      'fixed': 'fixed-index.html',
      'fluid': 'fluid-index.html',
      'mini': 'mini-index.html'
    }"></app-settings>
    </div>

    <!-- jQuery -->
    <script src="/vendor/jquery.min.js"></script>

    <!-- Bootstrap -->
    <script src="/vendor/popper.min.js"></script>
    <script src="/vendor/bootstrap.min.js"></script>

    <!-- Perfect Scrollbar -->
    <script src="/vendor/perfect-scrollbar.min.js"></script>

    <!-- DOM Factory -->
    <script src="/vendor/dom-factory.js"></script>

    <!-- MDK -->
    <script src="/vendor/material-design-kit.js"></script>

    <!-- Range Slider -->
    <script src="/vendor/ion.rangeSlider.min.js"></script>
    <script src="/js/ion-rangeslider.js"></script>

    <!-- App -->
    <script src="/js/toggle-check-all.js"></script>
    <script src="/js/check-selected-row.js"></script>
    <script src="/js/dropdown.js"></script>
    <script src="/js/sidebar-mini.js"></script>
    <script src="/js/app.js"></script>

    <!-- App Settings (safe to remove) -->
    <script src="/js/app-settings.js"></script>


    <!-- Flatpickr -->
    <script src="/vendor/flatpickr/flatpickr.min.js"></script>
    <script src="/js/flatpickr.js"></script>

    <!-- Global Settings -->
    <script src="/js/settings.js"></script>

    <!-- Moment.js -->
    <script src="/vendor/moment.min.js"></script>
    <script src="/vendor/moment-range.js"></script>


    <!-- Chart.js -->
    <script src="/vendor/Chart.min.js"></script>

    <!-- App Charts JS -->
    <script src="/js/chartjs-rounded-bar.js"></script>
    <script src="/js/charts.js"></script>

    <!-- Chart Samples -->
    <script src="/js/page.analytics.js"></script>


</body>

</html>