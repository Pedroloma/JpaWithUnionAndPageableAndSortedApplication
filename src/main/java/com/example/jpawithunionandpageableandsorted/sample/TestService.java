package com.example.jpawithunionandpageableandsorted.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TestService
{
  @Autowired
  private final TestRepository testRepository;

  public Page<Test> getAllPageable()
  {
    Pageable pageable = PageRequest.of(0, 10);
    return testRepository.findAllWithUnions(pageable);
  }

  public Page<Test> getAllPageableAndSorted()
  {
    Sort type = Sort.by("Type").ascending();
    Pageable pageable = PageRequest.of(0, 10, type);
    return testRepository.findAllWithUnions(pageable);
  }

  public void populateData()
  {
    Test test = new Test();
    test.setType("A");
    testRepository.save(test);
    test = new Test();
    test.setType("B");
    testRepository.save(test);
  }

  public TestService()
  {
    testRepository = null;
  }
}
