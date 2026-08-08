import SocialMedia from "./SocialMedia"
import QuickLinks from "./QuickLinks"
import Support from "./Support"
import ContactUs from "./ContactUs"

export default function Footer(){
    return (
        <div className={`d-flex justify-content-between bg-body-secondary`} style={{padding:"0px 160px"}}>
            <SocialMedia></SocialMedia>
            <QuickLinks></QuickLinks>
            <Support></Support>
            <ContactUs></ContactUs>
        </div>
    )
}