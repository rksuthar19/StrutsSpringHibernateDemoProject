<html>
<head>
    <title>Rent a Movie</title>
    <link href="styles/wizard.css" rel="stylesheet" type="text/css"></link>
    <script type="text/javascript" src="js/wizard.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#wizard').wizard({
                validate: function (idx, elem) {
                    switch (idx) {
                        case 0:
                            if ($('input[name=movieNames]:checked').size() == 0) {
                                alert('Please select at least one movie');
                                return false;
                            }
                            return true;
                        case 2:
                            if ($('input[name=customerName]:checked').size() != 1) {
                                alert('Please select a customer');
                                return false;
                            }
                            return true;
                        default:
                            return true;
                    }
                }
            });
        });
    </script>
</head>
<body>
<h1>Return a Movie</h1>

<form id="wizard" class="wiz-container" action="returnMovies">
    <ul class="wiz-list">
        <li><a href="#wizard-1">
            <h2>Return Movies</h2>
            <small>Pick a movie to return</small>
        </a></li>
    </ul>
    <div class="wiz-body">
        <div id="wizard-1">
            <div class="wiz-content movielist">
            <#list rentals as r>
                <div class="movie">
                    <p><input type="checkbox" name="movieNames" value="${r.movie.title}"/> ${r.movie.title}</p>
                </div>
            </#list>
            </div>
            <div class="wiz-nav">
                <input class="back btn" type="button" value="< Cancel"/>
                <input class="done btn" type="submit" value="Done"/>
            </div>
        </div>
    </div>
</form>
</body>
</html>
