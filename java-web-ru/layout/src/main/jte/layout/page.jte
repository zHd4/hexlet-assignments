@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            html {
              font: 18px/1.5 sans-serif;
            }

            body {
              background-color: #1e2121;
              color: #fff;
              margin: 0;
            }

            header {
                color: #fff;
                padding: 20px;
                background-color: #343939;
                margin: 0;
            }

            header > h2, nav {
                display: inline;
            }

            header > nav > ul {
                display: inline;
            }

            header > nav > ul > li{
                display: inline;
            }

            a {
              color: unset;
            }

            a.header-menu-link {
                text-decoration: unset;
                margin-left: 13px;
            }
        </style>
    </head>
    <body>
        <header>
            <h2>Users</h2>

            <nav id="menu">
                <ul>
                    <li><a class="header-menu-link" href="/">Home</a></li>
                    <li><a class="header-menu-link" href="/users">Users List</a></li>
                </ul>
            </nav>
        </header>

        ${content}

<%--        <footer>--%>
<%--            <span>Users - 2024</span>--%>
<%--        </footer>--%>
    </body>
</html>