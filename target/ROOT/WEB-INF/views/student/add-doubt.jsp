<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add | Course</title>

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
                <div class="mdk-header-layout__content mdk-header-layout__content--fullbleed mdk-header-layout__content--scrollable page" style="padding-top: 60px;">





                    <div class="page__heading">
                        <div class="container-fluid page__container">
                            <h1 class="mb-0">Ask Doubt?</h1>
                        </div>
                    </div>
                    <center>
                    <div class="Container" style="width:500px;margin:20px">
                    <form action="/student/adddoubt" method="post">
					  
                        <div class="form-outline mb-4">
                            <label class="form-label" for="form4Example1">Ask doubts/queries</label>
                          <input type="text" id="form4Example1" placeholder="ask doubt here..." name="doubtQues" class="form-control" />
                          
                        </div>
					
					  <button type="submit" class="btn btn-primary btn-block mb-4">ASK</button>
					</form>
					</div>
                    </center>

                </div>
                <!-- // END header-layout__content -->

            </div>
            <!-- // END header-layout -->

        </div>
        <!-- // END drawer-layout__content -->

       <%@ include file="sidebar.jsp" %>
    </div>
    <!-- // END drawer-layout -->

    <div class="mdk-drawer js-mdk-drawer" id="events-drawer" data-align="end">
        <div class="mdk-drawer__content">
            <div class="sidebar sidebar-light sidebar-left" data-perfect-scrollbar>




                <small class="text-dark-gray px-3 py-1">
                    <strong>Thursday, 28 Feb</strong>
                </small>

                <div class="list-group list-group-flush">

                    <div class="list-group-item bg-light">
                        <div class="row">
                            <div class="col-auto d-flex flex-column">
                                <small>12:30 PM</small>
                                <small class="text-dark-gray">2 hrs</small>
                            </div>
                            <div class="col">
                                <div class="d-flex flex-column flex">
                                    <a href="#" class="text-body"><strong class="text-15pt">Marketing Team Meeting</strong></a>

                                    <small class="text-muted d-flex align-items-center"><i class="material-icons icon-16pt mr-1">location_on</i> 16845 Hicks Road</small>


                                </div>
                                <div class="avatar-group mt-2">

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_joao-silas-636453-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_jeremy-banks-798787-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_daniel-gaffey-1060698-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <small class="text-dark-gray px-3 py-1">
                    <strong>Wednesday, 27 Feb</strong>
                </small>

                <div class="list-group list-group-flush">

                    <div class="list-group-item bg-light">
                        <div class="row">
                            <div class="col-auto d-flex flex-column">
                                <small>07:48 PM</small>
                                <small class="text-dark-gray">30 min</small>
                            </div>
                            <div class="col">
                                <div class="d-flex flex-column flex">
                                    <a href="#" class="text-body"><strong class="text-15pt">Call Alex</strong></a>


                                    <small class="text-muted d-flex align-items-center"><i class="material-icons icon-16pt mr-1">phone</i> 202-555-0131</small>

                                </div>



                            </div>
                        </div>
                    </div>

                </div>

                <small class="text-dark-gray px-3 py-1">
                    <strong>Tuesday, 26 Feb</strong>
                </small>

                <div class="list-group list-group-flush">

                    <div class="list-group-item bg-light">
                        <div class="row">
                            <div class="col-auto d-flex flex-column">
                                <small>03:13 PM</small>
                                <small class="text-dark-gray">2 hrs</small>
                            </div>
                            <div class="col">
                                <div class="d-flex flex-column flex">
                                    <a href="#" class="text-body"><strong class="text-15pt">Design Team Meeting</strong></a>

                                    <small class="text-muted d-flex align-items-center"><i class="material-icons icon-16pt mr-1">location_on</i> 16845 Hicks Road</small>


                                </div>
                                <div class="avatar-group mt-2">

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_rsz_1andy-lee-642320-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_michael-dam-258165-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                    <div class="avatar avatar-xs">
                                        <img src="/images/256_luke-porter-261779-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                    <div class="avatar avatar-xs">
                                        <img src="/images/stories/256_rsz_clem-onojeghuo-193397-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <small class="text-dark-gray px-3 py-1">
                    <strong>Monday, 25 Feb</strong>
                </small>

                <div class="list-group list-group-flush">

                    <div class="list-group-item bg-light">
                        <div class="row">
                            <div class="col-auto d-flex flex-column">
                                <small>12:30 PM</small>
                                <small class="text-dark-gray">2 hrs</small>
                            </div>
                            <div class="col d-flex">
                                <div class="d-flex flex-column flex">
                                    <a href="#" class="text-body"><strong class="text-15pt">Call Wendy</strong></a>


                                    <small class="text-muted d-flex align-items-center"><i class="material-icons icon-16pt mr-1">phone</i> 202-555-0131</small>

                                </div>


                                <div class="avatar avatar-xs">
                                    <img src="/images/256_michael-dam-258165-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle">
                                </div>


                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>

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