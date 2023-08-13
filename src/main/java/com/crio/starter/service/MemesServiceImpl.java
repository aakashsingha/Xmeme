package com.crio.starter.service;

import java.lang.module.ResolutionException;
import java.util.List;
import com.crio.starter.RepositoryService.MemeRepositoryService;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.PostMemesRequest;
import com.crio.starter.exchange.PostMemesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemesServiceImpl implements MemesService {


    @Autowired
    private MemeRepositoryService memeRepositoryService;

    @Override
    public PostMemesResponse setMemes(PostMemesRequest postMemesRequest)
    {

        List<MemeEntity> r=memeRepositoryService.viewMemes();
        for(MemeEntity i: r)
        {
            if(postMemesRequest.getName().equals(i.getName()) && postMemesRequest.getUrl().equals(i.getUrl()) && postMemesRequest.getCaption().equals(i.getCaption()))
            {
                throw new ResponseStatusException( 
                    HttpStatus.NOT_FOUND, "the page is not found" 
                  );

            }
        }
        MemeEntity memeEntity = new MemeEntity();
        memeEntity.setName(postMemesRequest.getName());
        memeEntity.setUrl(postMemesRequest.getUrl());
        memeEntity.setCaption(postMemesRequest.getCaption());
       MemeEntity res= memeRepositoryService.saveMeme(memeEntity);
       PostMemesResponse postMemesResponse = new PostMemesResponse(res.getId());
       return postMemesResponse;
    }

    @Override
    public MemeEntity viewMemeById(int id)
    {
        MemeEntity res=memeRepositoryService.findMemeById(id);
        return res;
    }

    @Override
    public List<MemeEntity> viewMemes()
    {
        List<MemeEntity> res= memeRepositoryService.viewMemes();
        return res;
        
    }
}
