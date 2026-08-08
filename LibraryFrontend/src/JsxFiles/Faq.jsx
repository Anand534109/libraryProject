import faq from '../cssFiles/faq.module.css'
import Faqscript from "../jsfiles/FaqScript"
import { useEffect, useState,useRef} from 'react'

export default function Faq(){
    // const[open ,setOpen] =useState(false);
    const[openIndex,setOpenIndex] = useState(null);
    const ref = useRef([]);
    
    return (
        <div style={{padding:"0px 160px"}}>
            {Faqscript.map((item,index)=>(
                <div key={index} >
                    <div className={faq.question} onClick={()=>setOpenIndex(openIndex === index? null:index)}>{item.question}</div>
                    <div className={faq.Showanswer} ref={(el)=>ref.current[index] =el} style={{height:openIndex === index?ref.current[index]?.scrollHeight+"px":"0px"}}>
                        <div className={faq.answer}>{item.answer}</div>
                    </div>
                </div>
            ))}
            
        </div>
    )
}