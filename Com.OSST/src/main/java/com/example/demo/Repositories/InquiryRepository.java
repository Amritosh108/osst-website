
package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
