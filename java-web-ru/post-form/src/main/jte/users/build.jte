@template.layout.page(
    content = @`
        <style>
            .fg-mr {
                margin-top: 10px;
            }

            .r-btn-mr {
                margin-top: 20px;
            }
        </style>

        <form action="/users" method="post">
            <div class="form-group fg-mr">
                <label>
                    Имя
                    <input type="text" name="firstName" class="form-control" placeholder="Введите имя" required>
                </label>
            </div>

            <div class="form-group fg-mr">
                <label>
                    Фамилия
                    <input type="text" class="form-control" name="lastName" placeholder="Введите фамилию" required>
                </label>
            </div>

            <div class="form-group fg-mr">
                <label>
                    Email
                    <input type="email" class="form-control" name="email" placeholder="Введите email" required>
                </label>
            </div>

            <div class="form-group fg-mr">
                <label>
                    Пароль
                    <input type="password" class="form-control" name="password" placeholder="Введите пароль" required>
                </label>
            </div>

            <div class="form-group r-btn-mr">
                <button type="submit" class="btn btn-primary">Зарегистрировать</button>
            </div>
        </form>
    `
)