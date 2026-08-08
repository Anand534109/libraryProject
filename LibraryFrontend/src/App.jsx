import {BrowserRouter,Routes,Route} from 'react-router-dom';
import {lazy,Suspense} from 'react';
import { useEffect ,useState} from 'react';

const Home = lazy(()=>import('./JsxFiles/Home'));
const SingUp = lazy(()=>import('./JsxFiles/SignUp'));
const Login = lazy(()=>import('./JsxFiles/Login'));
const BookView1 = lazy(()=>import('./bookviews/BookView1'));
const BookDetail = lazy(()=>import('./JsxFiles/BookDetail'));
const ShowBooks = lazy(()=>import('./JsxFiles/ShowBooks'));
const FavrateList = lazy(()=>import('./JsxFiles/FavrateList'));

function App(){
  

  return (

    <BrowserRouter>
    <Suspense fallback={<h1>loding......</h1>} >
      <Routes>
        <Route path='*' element={<h1>no route found</h1>}/>
        <Route path='/home' element={<Home/>}/>
        <Route path='/signup' element={<SingUp/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/home/bookdetail/:id" element={<BookDetail/>}/>
        <Route path="/home/bookdetail/:id/view" element={<BookView1/>}/>
        <Route path="/home/catagory/:name" element={<ShowBooks/>}/>
        <Route path="/home/favourite" element={<FavrateList/>}/>
      </Routes>
    </Suspense>
    </BrowserRouter>
   
  )
}

export default App;