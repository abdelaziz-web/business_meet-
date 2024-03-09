<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="style.css">
    <title>Modern Login Page | AsmrProg</title>
</head>


<h2>  Bridge  </h2>

<br> 
<br>
<c:out value="${requestScope.message}" />

<br>
<br>
<body>

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form method="post" action="servlet">

                <h1>Create Account</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registeration</span>
 
                <input type="text" placeholder="last name" name="nom"  required >
                <input type="text" placeholder="first name" name="prenom" required >
                <input type="email" id="email" name="email" placeholder="email"  required>
                <input type="password" id="motDePasse" name="motDePasse" placeholder="password"  required>
                <input type="submit" value="Enregistrer" placeholder="email" >
         
            </form>
            
                
        </div>
        <div class="form-container sign-in">
        
              <a  style="color: white;" href="form_p_i_.jsp" >     <button>  Switch to Innovator space  space  </button> </a>
        
                <form method ="post" action="auth">
                <h1>Sign In</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your email password</span>
               
                <input type="email"  id="staticEmail" name="email" placeholder="email@example.com">
                
               
                <input type="password"  id="inputPassword" name="password"  placeholder="Password">
                
                
                <button>Sign In</button>
            </form>
            
            
            
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Innovator!</h1>
                    <p>Register with your personal details to use our service</p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
            
        </div>
    </div>

    <script src="script.js"></script>
</body>

</html>