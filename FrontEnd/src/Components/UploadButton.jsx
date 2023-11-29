import { Button } from "@mui/material";
function UploadButton({ onClick, variant, children}){
    

    return(
        <Button variant={variant} onClick={onClick}>
            {children}
        </Button>
    )

}
export default UploadButton;