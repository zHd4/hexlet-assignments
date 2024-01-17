@import exercise.dto.users.UserPage
@param UserPage page

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
            }

            a {
              color: unset;
            }

            h1,
            h3 {
              margin-block: unset;
            }

            .user-cart {
              color: #fff;
              width: 300px;
              height: 300px;
              background-color: #343a40;
              margin-left: auto;
              margin-right: auto;
              margin-top: 10%;
              padding: 20px;
            }
        </style>

        <title>Users</title>
    </head>
    <body>
        <div class="user-cart">
            <h3>#${page.getUser().getId()}</h3>
            <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
            <span><b>Email:</b> <a href="mailto: ${page.getUser().getEmail()}">${page.getUser().getEmail()}</a></span>
        </div>
    </body>
</html>
