<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="uk">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="view/style/mainStyle.css">

    <title>Online School</title>

    <link rel="apple-touch-icon" sizes="180x180" href="view/resource/IconLogo/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="view/resource/IconLogo/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="view/resource/IconLogo/favicon-16x16.png">
    <link rel="manifest" href="/site.webmanifest">
</head>





<body>

<header>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp?name=<%= page %>">Online School</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp?name=<%= page %>">Головна сторінка</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="view/registration.html">Зареєструватись</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="view/history.html">Історія перегляду</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Дивитись сутності
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="add%20materials.html">Додоткові матеріали</a></li>
                            <li><a class="dropdown-item" href="view/homeworks.html">Домашня робота</a></li>
                            <li><a class="dropdown-item" href="view/courses.html">Курси</a></li>
                            <li><a class="dropdown-item" href="view/lectures.html">Лекції</a></li>
                            <li><a class="dropdown-item" href="view/getAllStudents.jsp">Студенти</a></li>
                            <li><a class="dropdown-item" href="view/teachers.html">Викладачі</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Дз по Томкету
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="view/students.jsp">Додати студента</a></li>
                            <li><a class="dropdown-item" href="view/getAllStudents.jsp">Дивитись всіх студентів</a></li>
                            <li><a class="dropdown-item" href="view/getTheOneStudent.jsp">Обрати конкретного студента</a></li>
                            <li><a class="dropdown-item" href="view/deleteTheOneStudent.jsp">Видалити конкретного студента</a></li>

                        </ul>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

</header>


<div class="Video">
    <video autoplay muted loop playsinline id="video-bg">
        <source src="view/resource/STG_flash.mp4" type="video/mp4">
    </video>
</div>

<section>
    <div class="conteiner-fluid">
        <div class="row">


            <div class="col1 col-lg-4">
                <a href="view/studentsLastNameByNaturalOrder.html">
                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.33.28%20-%20students%20in%20aquamarine%20painting%20style.png"
                             class="card-img-top" alt="students">
                        <div class="card-body">
                            <p class="card-text">Дані про студентів відсортовані за прізвищем.</p>
                        </div>
                    </div>
                </a>
                <a href="view/lecturesBefore2023.html">
                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.34.31%20-%20lection%20in%20school%20in%20aquamarine%20painting%20style.png"
                             class="card-img-top" alt="lection">
                        <div class="card-body">
                            <p class="card-text">Інформація про лекції, та кількість матеріалів, які вони містять,
                                відсортовані за датою та які проходили до 2023 року.</p>
                        </div>
                    </div>
                </a>

            </div>


            <div class="col2 col-lg-4">
                <a href="view/theFirstLectureWithaddMatt.html">

                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.34.51%20-%20lection%20in%20school%20in%20aquamarine%20painting%20style.png"
                             class="card-img-top" alt="lection">
                        <div class="card-body">
                            <p class="card-text">Інформація про лекцію, яка містить найбільшу кількість домашніх
                                завдань та яка була створена раніше за всіх.</p>
                        </div>
                    </div>
                </a>
                <a href="view/addMatByResourceType.html">

                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.35.51%20-%20books%20in%20school%20in%20%20painting%20style.png"
                             class="card-img-top" alt="add materials">
                        <div class="card-body">
                            <p class="card-text">Кількість додаткових матеріалів по кожній категорії.</p>
                        </div>
                    </div>
                </a>
            </div>



            <div class="col3 col-lg-4">
                <a href="view/teachersLastnameBeforeN.html">

                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.36.39%20-%20teachers%20in%20school%20in%20aquamarine%20painting%20style.png"
                             class="card-img-top" alt="teachers">
                        <div class="card-body">
                            <p class="card-text">Список вчителів, прізвища яких починаються з літер, які стоять до
                                англійської "N" , або української "Н".</p>
                        </div>
                    </div>
                </a>
                <a href="view/studentsInOneTWoThreeCourses.html">

                    <div class="card" style="width: 18rem;">
                        <img src="view/resource/DALL·E%202023-03-27%2013.37.08%20-%20students%20in%20school%20in%20aquamarine%20painting%20style.png"
                             class="card-img-top" alt="students">
                        <div class="card-body">
                            <p class="card-text">Інформація про студентів, які записані тільки на один, на два, три
                                або більше курси, відсортована за прізвищем.</p>
                        </div>
                    </div>
                </a>
            </div>>

        </div>


</section>



<footer>
    <div class="conteiner-fluid">
        <div class="row">
            <div class="col-lg-4 col-md-12 footer-text text-center">
                <p>
                    Всі права захищено
                    <img style="width: 30px;" src="view/resource/Copyright-Symbol.png" alt="Copyright-Symbol">
                </p>
                <div class="textCity">
                    <p>Ніжин - Київ, 2023</p>
                </div>

            </div>
            <div class="col-lg-4 col-md-12 footer-text text-center">
                <a href="#">

                    <img style="width: 25px;" src="view/resource/contact-phone-icon-4.png" alt="contact img"> Контакти
                    <br>

                </a>
                <a href="#">

                    <img style="width: 25px;" src="view/resource/png-transparent-handshake-cooperation.png"
                         alt="cooperation img"> Співпраця з нами <br>
                </a>
                <a href="#">

                    <img style="width: 25px;" src="view/resource/team-icon-24.png" alt="our team img"> Наша команда
                </a>
            </div>
            <div class="col-lg-4 col-md-12 media-links">
                Наші сторінки:

                <a href="https://t.me/Serhii_Mshkvts" target="_blank">
                    <img class="socialMediaLogo" src="view/resource/Telegram_logo.svg.png" alt="telegram logo">
                </a>
                <a href="https://www.instagram.com/serhii_mshkvts/" target="_blank">
                    <img class="socialMediaLogo" src="view/resource/640px-Instagram_icon.png" alt="insta logo">
                </a>
                <a href="https://github.com/Serhii-Mashkovets" target="_blank">
                    <img class="socialMediaLogo" src="view/resource/25231.png" alt="github logo" width="512"
                         height="512">
                </a>


            </div>
        </div>
    </div>
</footer>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>