
import React from "react";
import { Fab, Button } from "@mui/material";
import UploadIcon from "@mui/icons-material/Upload";

const FileUpload = ({ onSelectFile, fileName }) => {
  return (
    <div style={{ paddingTop: "40px", paddingLeft: "40px" }}>
      <label htmlFor="file">
        <input
          style={{ display: "none" }}
          id="file"
          name="file"
          type="file"
          onChange={(e) => onSelectFile(e)}
        />

        <Fab
          style={{
            border: "2.5px solid blue",
            height: "60px",
            width: "260px",
            backgroundColor: "white",
          }}
          size="small"
          component="span"
          aria-label="add"
          variant="extended"
        >
          <UploadIcon />
          <div
            style={{
              color: "blue",
              backgroundColor: "white",
            }}
          >
            <strong>Select a file</strong>
          </div>
        </Fab>
      </label>
      <div style={{ marginTop: '10px' }}>{fileName}</div>
      <br></br>
      <br></br>
    </div>
  );
};

export default FileUpload;
