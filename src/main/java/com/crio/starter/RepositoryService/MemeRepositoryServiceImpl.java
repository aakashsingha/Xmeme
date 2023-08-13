package com.crio.starter.RepositoryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.management.RuntimeErrorException;
//import javax.management.RuntimeErrorException;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.MemeNotFoundException;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.utils.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class MemeRepositoryServiceImpl implements MemeRepositoryService{

@Autowired
private MemeRepository memeRepository;

@Autowired SequenceGenerator sequenceGenerator;
public MemeEntity saveMeme(MemeEntity memeEntity)
{
   memeEntity.setId(sequenceGenerator.generateSequence(MemeEntity.SEQUENCE_NAME));
   MemeEntity res= memeRepository.save(memeEntity);
   return res;
}
    

@Override
public MemeEntity findMemeById(int id)
{
   MemeEntity res= memeRepository.findById(id).orElseThrow(()-> new ResponseStatusException( 
      HttpStatus.NOT_FOUND, "the page is not found" 
    ) );
   return res;
}


@Override
public List<MemeEntity> viewMemes() {
   List<MemeEntity> r=memeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
   List<MemeEntity> res= new ArrayList<MemeEntity>();
  if(r.size()>=100)
   {
      for(int i=r.size()-100;i<r.size();i++)
      {
         res.add(r.get(i));
      }
       Collections.reverse(res);
       return res;
   }
   else{
      return r;
   }
}
}
