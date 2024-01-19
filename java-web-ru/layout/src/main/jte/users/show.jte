@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <style>
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

    <div class="user-cart">
        <h3>#${page.getUser().getId()}</h3>
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <span><b>Email:</b> <a href="mailto: ${page.getUser().getEmail()}">${page.getUser().getEmail()}</a></span>
    </div>
`)
