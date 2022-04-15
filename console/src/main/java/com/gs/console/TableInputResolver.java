package com.gs.console;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @User远
 * @Date2022/4/14
 */
@Slf4j
@Configuration
public class TableInputResolver extends CommonsMultipartResolver {
    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = this.determineEncoding(request);
        FileUpload fileUpload = this.prepareFileUpload(encoding);
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return this.parseFileItems(fileItems, encoding);
        } catch (OutOfMemoryError error) {
            throw new OutOfMemoryError();
        } catch (SizeLimitExceededException e){
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), e);
        } catch (FileSizeLimitExceededException e){
            throw new MaxUploadSizeExceededException(fileUpload.getFileSizeMax(), e);
        } catch (Exception e) {
            throw new MultipartException("Failed to parse multipart servlet request");
        }
    }
}
