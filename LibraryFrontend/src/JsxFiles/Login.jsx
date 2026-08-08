import NavBar from "./NavBar"
import form from "../cssFiles/signup.module.css";
import {Link , useNavigate} from "react-router-dom"
import { useRef } from "react";

export default function Login(){
    const emailRef = useRef();
    const passwordRef = useRef();
    const navigate = useNavigate();
    function handleSubmit(e){
        e.preventDefault();
        const loginData= {
            email:emailRef.current.value,
            password:passwordRef.current.value
        }

        const response = fetch("http://localhost:8080/User/login",{
            method:"POST",
            credentials:"include",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(loginData)
        });
        response.then(res=>{
            if(res.ok){
                navigate("/home",{replace:true})
            }
        })
        // .then(data => console.log(data))
        .catch(error =>console.log("error => ",error))
    }
    return (
        <div>
            <NavBar></NavBar>
            <div className={form.signupform} >
                <h2 style={{textAlign:"center"}}>Login User</h2>
                <form className="row g-3 needs-validation" onSubmit={(e)=>handleSubmit(e)}>
                    
                    <div className="col-md-12">
                        <label htmlFor="validationCustom03" className="form-label">Email</label>
                        <div className="input-group has-validation">
                            <input type="email" ref={emailRef} className="form-control" id="validationCustom03" name="email" required/>
                            <div className="invalid-feedback">
                             Please enter valid Email
                            </div>
                        </div>
                    </div>
                     <div className="col-md-12">
                        <label htmlFor="validationCustom04" className="form-label">Password</label>
                        <div className="input-group has-validation">
                            <input type="password" ref={passwordRef} className="form-control" id="validationCustom04" name="password" required/>
                            <div className="invalid-feedback">
                                Please enter valid password
                            </div>
                        </div>
                    </div>

                    
                    <div className="col-12" style={{textAlign:"center"}}>
                        <button className ="btn btn-primary" type="submit" style={{width:"150px",fontSize:"20px"}}>Login</button>
                    </div>
                    <div className="col-12"  style={{display:"flex",gap:"50px", alignItems:"center"}}>
                        <p style={{fontSize:"20px",margin:"0px"}}>Create New Account</p>
                        <Link className={form.link}>SignUp here</Link>
                    </div>
                </form>
            </div>
        </div>
    )
}