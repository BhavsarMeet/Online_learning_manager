<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Faculty | Dashboard</title>

    <!-- Prevent the demo from appearing in search engines -->
    <meta name="robots" content="noindex">

    <!-- Perfect Scrollbar -->
    <link type="text/css" href="/vendor/perfect-scrollbar.css" rel="stylesheet">

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
                <div class="mdk-header-layout__content mdk-header-layout__content--fullbleed mdk-header-layout__content--scrollable page" style="padding-top: 60px;">





                    <div class="page__heading">
                        <div class="container-fluid page__container">
                            <h1 class="mb-0">Dashboard</h1>
                        </div>
                    </div>
                    ${erroredit }
                    ${successupdate }
                    ${errorupdate }
                   
                    <div class="container-fluid page__container">
                        <div class="tab-content">
                            <div class="tab-pane active show fade" id="activity_all">
                                <!-- FIRST TAB CONTENT -->
                                <div class="row card-group-row">
                                    <div class="col-lg-4 col-md-6 card-group-row__col">
                                        <div class="card card-group-row__card">
                                            <div class="card-body-x-lg card-body d-flex flex-row align-items-center">
                                                <div class="flex">
                                                <a href="/teacher/courses">
                                                    <div class="card-header__title text-muted mb-2 d-flex">All Course <span class="badge badge-warning ml-2"></span></div>
                                                    <span class="h4 m-0">${totalTeacherCourse} </span>
                                                 </a>
                                                </div>
                                                <div><i class="material-icons icon-muted icon-40pt ml-3">layers</i></div>
                                            </div>
                                            <div class="progress" style="height: 3px;">
                                                <div class="progress-bar bg-warning" role="progressbar" style="width: 100%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-6 card-group-row__col">
                                        <div class="card card-group-row__card">
                                            <div class="card-body-x-lg card-body d-flex flex-row align-items-center">
                                                <div class="flex">
                                                <a href="/quiz/quiz-manager">
                                                    <div class="card-header__title text-muted d-flex mb-2">All Quiz </div>
                                                    <span class="h4 m-0">${totalTeacherQuiz }</span>
                                                 </a>
                                                </div>
                                                <div><i class="material-icons icon-muted icon-40pt ml-3">pages</i></div>
                                            </div>
                                            <div class="progress" style="height: 3px;">
                                                <div class="progress-bar" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                   <div class="col-lg-4 col-md-6 card-group-row__col">
                                        <div class="card card-group-row__card">
                                            <div class="card-body-x-lg card-body d-flex flex-row align-items-center">
                                                <div class="flex">
                                                    <div class="card-header__title text-muted d-flex mb-2">All Quiz </div>
                                                    <span class="h4 m-0">${totalQuiz }</span>
                                                </div>
                                                <div><i class="material-icons icon-muted icon-40pt ml-3">pages</i></div>
                                            </div>
                                            <div class="progress" style="height: 3px;">
                                                <div class="progress-bar bg-warning" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- END FIRST TAB CONTENT -->
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