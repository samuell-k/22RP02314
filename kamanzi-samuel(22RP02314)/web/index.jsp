<!DOCTYPE html>
<html>
<head>
    <title>Add Item to Cart</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e0f7fa;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
        }
        h1 {
            text-align: center;
            color: #00796b;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #004d40;
        }
        .form-group input {
            width: 100%;
            padding: 12px;
            border: 2px solid #004d40;
            border-radius: 6px;
        }
        .form-group input[type="submit"] {
            background-color: #004d40;
            color: #ffffff;
            border: none;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #00251a;
        }
        .actions {
            text-align: center;
            margin-top: 25px;
        }
        .actions a {
            text-decoration: none;
            color: #004d40;
            font-weight: 600;
        }
        .actions a:hover {
            color: #00251a;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Item to Cart</h1>
        <form method="post" action="add_Items">
            <div class="form-group">
                <label for="item">Item Name</label>
                <input type="text" id="item" name="item" required>
            </div>
            <div class="form-group">
                <label for="cost">Cost</label>
                <input type="number" id="cost" name="cost" step="0.01" min="0" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Add to Cart">
            </div>
        </form>
        <div class="actions">
            <a href="view_carts">View Cart</a>
        </div>
    </div>
</body>
</html>
