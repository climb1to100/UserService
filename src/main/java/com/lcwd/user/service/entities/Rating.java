package com.lcwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private ObjectId id;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedback;
}
