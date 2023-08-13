package com.crio.starter.RepositoryService;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepositoryService {

 MemeEntity saveMeme(MemeEntity memeEntity);
 MemeEntity findMemeById(int id);
 List<MemeEntity> viewMemes();
    
}
