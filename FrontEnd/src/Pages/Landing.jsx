
import { useState } from "react";
import axios from "axios";
import image from '../clarinet.jpg'
import UploadButton from "../Components/UploadButton";
import FileUpload from "../Components/FileUpload";
import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';
import {BASE_API_URL,SCORE_API_URL,AUTH_TOKEN } from "../Constants";

function Landing(){

    const[file,setFile]=useState(null);
    const[loading,setLoading] = useState(false);
    const[fileName,setFileName] = useState("");

    const handleFileSelect = (e) => {
      const file = e.target.files[0];
      const file_Name = e.target.files[0].name;
      setFile(file);
      setFileName(file_Name);
    };


    function handleUpload(e){
        e.preventDefault();
        setLoading(true);
        if(!file){
            console.log("No file selected");
            return;
        }
        const formdata = new FormData();
        formdata.append("file",file);
        const url = BASE_API_URL + SCORE_API_URL
        axios.post(url,formdata,{
            headers: {
             'content-type': 'multipart/form-data', // do not forget this ,
             'Authorization':AUTH_TOKEN 
            }}
            ).then(res=>{
            const resUrl = res.data.htmlUrl;
            console.log(resUrl);
            setLoading(false);
            window.open(resUrl);
            })
            .catch(err=>{console.log(err)});

    }

    return(
        <div style={{backgroundImage:`url(${image})`,height:'100vh',width:'100vw',backgroundPosition:'center',backgroundSize:'cover',backgroundRepeat:'no-repeat'}}>
            <div style={{paddingLeft:"50px",fontFamily:"serif",color:"blue"}}>
            <h1>Welcome to music score generator</h1>
            </div>

            <FileUpload onSelectFile={handleFileSelect} fileName={fileName} />

                <div style={{paddingLeft:"35px", paddingTop:'40px'}}>
                <UploadButton variant="contained" onClick={handleUpload}>Upload</UploadButton>
                </div>

                {loading &&
                <div style={{paddingTop:"70px",paddingLeft:"850px"}}>
                  <Box sx={{ display: 'flex'}}>
                    <CircularProgress  />
                  </Box>
                </div>}
                
            
        </div>
    )
}
export default Landing;