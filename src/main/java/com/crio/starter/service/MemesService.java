package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.PostMemesRequest;
import com.crio.starter.exchange.PostMemesResponse;

public interface MemesService {

PostMemesResponse setMemes(PostMemesRequest postMemesRequest);
MemeEntity viewMemeById(int id);
List<MemeEntity> viewMemes();
}
