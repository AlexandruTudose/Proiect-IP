package com.fiivirtualcatalog.modules.transformers;

import java.util.ArrayList;
import com.fiivirtualcatalog.modules.DTOs.CheckInDTO;
import com.fiivirtualcatalog.modules.checkin.models.CheckIn;
import com.fiivirtualcatalog.modules.user.models.User;

public class CheckInTransformer implements Transformer<CheckIn, CheckInDTO> {
	
	@Override
	public CheckIn toModel(CheckInDTO object) {
		return new CheckIn().new Builder().user(object.getUser())
				.subject(object.getSubject())
				.classType(object.getClassType())
				.finishingFlag(object.getFinishingFlag())
				.numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
				.checkedInUsers(new ArrayList<User>())
				.createDate(object.getCreateDate())
				.create();
	}

	@Override
	public CheckInDTO toDTO(CheckIn object) {
		return new CheckInDTO().new Builder().user(object.getUser())
				.subject(object.getSubject())
				.classType(object.getClassType())
				.finishingFlag(object.getFinishingFlag())
				.numberOfCheckedInUsers(object.getNumberOfCheckedInUsers())
				.createDate(object.getCreateDate())
				.create();
	}

}
