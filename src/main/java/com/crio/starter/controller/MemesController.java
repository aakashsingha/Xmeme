package com.crio.starter.controller;

import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.PostMemesRequest;
import com.crio.starter.exchange.PostMemesResponse;
import com.crio.starter.exchange.ResponseDto;
//import com.crio.starter.service.GreetingsService;
import com.crio.starter.service.MemesService;
import lombok.RequiredArgsConstructor;
//import static org.mockito.ArgumentMatchers.isNull;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemesController {

  private final MemesService memesService;

  //post meme
  @PostMapping("/memes")
  public ResponseEntity<PostMemesResponse> setmemes(@RequestBody PostMemesRequest postMemesRequest)
  {
    if(Objects.isNull(postMemesRequest.getName()) || Objects.isNull(postMemesRequest.getUrl()) || Objects.isNull(postMemesRequest.getCaption()))
    {
      return ResponseEntity.badRequest().build();
    }
    PostMemesResponse postMemesResponse = memesService.setMemes(postMemesRequest);
    return ResponseEntity.ok().body(postMemesResponse);
  }

  //fetch meme according to id provided
  @GetMapping("/memes/{memeid}")
  public ResponseEntity<MemeEntity> viewMeme(@PathVariable("memeid") int id)
  {
    MemeEntity res=memesService.viewMemeById(id);
    return ResponseEntity.ok().body(res);
  }

  //fetch latest 100 memes in db.
  @GetMapping("/memes")
  public ResponseEntity<List<MemeEntity>> viewMemes()
  {
    List<MemeEntity> res= memesService.viewMemes();
    return ResponseEntity.ok().body(res);
  } 
}
