package com.example.point_career.domain.bookmark.service;

import com.example.point_career.domain.bookmark.dto.BookmarkCreateRequest;
import com.example.point_career.domain.bookmark.dto.BookmarkResponse;
import com.example.point_career.domain.bookmark.entity.BookmarkType;
import com.example.point_career.domain.bookmark.entity.PointBookmark;
import com.example.point_career.domain.bookmark.entity.RecruitBookmark;
import com.example.point_career.domain.bookmark.repository.PointBookmarkRepository;
import com.example.point_career.domain.bookmark.repository.RecruitBookmarkRepository;
import com.example.point_career.domain.point.entity.Point;
import com.example.point_career.domain.point.repository.PointRepository;
import com.example.point_career.domain.recruit.repository.RecruitRepository;
import com.example.point_career.domain.recruit.entity.Recruit;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.domain.user.repository.UserRepository;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

	private final UserRepository userRepository;
	private final PointBookmarkRepository pointBookmarkRepository;
	private final RecruitBookmarkRepository recruitBookmarkRepository;
	private final PointRepository pointRepository;
	private final RecruitRepository recruitRepository;

	@Override
	@Transactional
	public BookmarkResponse createBookmark(User user, BookmarkCreateRequest request) {
		User findUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_EXIST));

		if (BookmarkType.POINT == request.getTarget_type()) {
			Point findPoint = pointRepository.findById(request.getId())
					.orElseThrow(() -> new BaseException(BaseResponseStatus.POINT_NOT_EXIST));

			PointBookmark pointBookmark = PointBookmark.builder()
					.point(findPoint)
					.user(findUser)
					.build();
			pointBookmarkRepository.save(pointBookmark);

			return BookmarkResponse.builder()
					.bookmark_id(pointBookmark.getId())
					.target_type(BookmarkType.POINT)
					.build();
		}

		Recruit findRecruit = recruitRepository.findById(request.getId())
				.orElseThrow(() -> new BaseException(BaseResponseStatus.RECRUIT_NOT_EXIST));

		RecruitBookmark recruitBookmark = RecruitBookmark.builder()
				.recruit(findRecruit)
				.user(findUser)
				.build();
		recruitBookmarkRepository.save(recruitBookmark);

		return BookmarkResponse.builder()
				.bookmark_id(recruitBookmark.getId())
				.target_type(BookmarkType.RECRUIT)
				.build();
	}

	@Override
	@Transactional
	public BookmarkResponse deleteBookmark(BookmarkType bookmarkType, Long bookmarkId) {
		if (BookmarkType.POINT == bookmarkType) {
			PointBookmark findPointBookmark = pointBookmarkRepository.findById(bookmarkId)
					.orElseThrow(() -> new BaseException(BaseResponseStatus.POINT_BOOKMARK_NOT_EXIST));
			pointBookmarkRepository.delete(findPointBookmark);

			return BookmarkResponse.builder()
					.bookmark_id(findPointBookmark.getId())
					.target_type(BookmarkType.POINT)
					.build();
		}

		RecruitBookmark findRecruitBookmark = recruitBookmarkRepository.findById(bookmarkId)
				.orElseThrow(() -> new BaseException(BaseResponseStatus.RECRUIT_BOOKMARK_NOT_EXIST));
		recruitBookmarkRepository.delete(findRecruitBookmark);

		return BookmarkResponse.builder()
				.bookmark_id(findRecruitBookmark.getId())
				.target_type(BookmarkType.RECRUIT)
				.build();
	}
}
